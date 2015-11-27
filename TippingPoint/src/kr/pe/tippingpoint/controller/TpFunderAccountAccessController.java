package kr.pe.tippingpoint.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.pe.tippingpoint.exception.DuplicatedIdException;
import kr.pe.tippingpoint.mail.Email;
import kr.pe.tippingpoint.mail.EmailSender;
import kr.pe.tippingpoint.service.TpFunderAccountAccessServiceImpl;
import kr.pe.tippingpoint.validator.TpFunderValidator;
import kr.pe.tippingpoint.validator.TpProposerValidator;
import kr.pe.tippingpoint.vo.TpBankList;
import kr.pe.tippingpoint.vo.TpFunder;
import kr.pe.tippingpoint.vo.TpProposer;

/**
 * 회원 로그인 작업을 처리하는 Controller
 */
@Controller
public class TpFunderAccountAccessController {

	@Autowired
	private TpFunderAccountAccessServiceImpl service;

	/**
	 * 로그인체크 컨트롤러
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "loginCheck", method = RequestMethod.POST)
	@ResponseBody
	public String loginProcess(@RequestParam String tpfId, @RequestParam String tpfPw, HttpSession session) {
		String loginId = tpfId;
		String loginPwd = tpfPw;

		if (loginId == null || loginId.trim().length() == 0) {// 로그인 Id가 값이없을때
			return "잘못된 입력입니다";
		}
		try {// 로그인 ID가 DB에 존재 유무 확인
			String TpFunderId = (service.findTpFunderById(loginId)).getTpfId();
			String TpFunderPwd = (service.findTpFunderById(loginId)).getTpfPassword();
			if (loginId.equals(TpFunderId) && loginPwd.equals(TpFunderPwd)) {
				session.setAttribute("userLoginInfo", loginId); // 세션생성
			} else {// 비밀번호가 틀렸을경우
				return "비밀번호가 틀렸습니다";
			}
			return "success";
		} catch (NullPointerException e) {// 로그인한 ID가 가입된회원이아님
			return "등록된 ID가 없습니다";
		}

	}

	/**
	 * 로그인 하는 컨트롤러
	 */
	@RequestMapping(value = "loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String backpage = String.valueOf(session.getAttribute("backpage"));
		System.out.println(backpage);
		mav.setViewName("redirect:" + backpage);
		return mav;
	}

	/**
	 * 누가봐도 로그아웃
	 * 
	 * @throws IOException
	 */
	@RequestMapping("logout")
	public String logout(HttpSession session, HttpServletResponse response) throws IOException {
		System.out.println(session.getAttribute("userLoginInfo"));
		session.invalidate(); // 세션 삭제
		response.sendRedirect("/TippingPoint/main.tp");
		return null;
	}

	/**
	 * 회원가입
	 * 
	 * @param tpfunder
	 * @param errors
	 * @param model
	 * @return
	 * @throws DuplicatedIdException
	 */
	@RequestMapping(value = "registerTpFunder", method = RequestMethod.POST)
	public String registerTpFunder(@ModelAttribute TpFunder tpfunder, Errors errors, ModelMap model)
			throws DuplicatedIdException {

		tpfunder.setTpfQualifyTpProposer("F"); // 제안자 권한 false
		tpfunder.setTpfAccountType("D"); // 계정 유형 DEfault / F: facebook
		TpFunderValidator validate = new TpFunderValidator();
		validate.validate(tpfunder, errors); // ★

		if (errors.hasErrors()) {
			return "/tpfunder/registerForm.tp";
		}

		service.addTpFunder(tpfunder);
		model.addAttribute("tpfunder", tpfunder);
		return "redirect:/tpfunder/registerSuccess.tp";
	}

	/**
	 * 회원가입 성공
	 * 
	 * @param tpfId
	 * @param model
	 * @return
	 */
	@RequestMapping("registerSuccess")
	public String registerSuccess(@RequestParam String tpfId, ModelMap model) {
		model.addAttribute("tpfunder", service.findTpFunderById(tpfId));
		return "tpfunder/registerSuccess.tiles";
	}

	@RequestMapping("idDuplicatedCheck")
	@ResponseBody
	public String idDuplicatedCheck(@RequestParam String tpfId) {
		TpFunder tpfunder = service.findTpFunderById(tpfId);
		return String.valueOf(tpfunder != null);
	}

	/**
	 * 회원수정폼 조회
	 * 
	 * @param tpfId
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("modifyForm")
	public String modifyForm(HttpSession session, ModelMap model) throws Exception {
		String userid = (String) session.getAttribute("userLoginInfo");
		TpFunder funder = service.findTpFunderById(userid);

		String list = funder.getTpfPhoneNum();
		String[] str = list.split("\\-");

		model.addAttribute("tpFunder", funder);
		model.addAttribute("tpfPhoneNum2", str[1]);
		model.addAttribute("tpfPhoneNum3", str[2]);
		System.out.println();
		return "tpMyPage/modifyRegister.tiles";
	}

	/**
	 * 회원수정
	 * 
	 * @param tpfunder
	 * @param errors
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("funderModifyRegister")
	public String modifyRegister(@ModelAttribute TpFunder tpfunder, Errors errors, ModelMap model, HttpSession session,
			HttpServletRequest request) throws Exception {
		TpFunderValidator validate = new TpFunderValidator();
		validate.validate(tpfunder, errors);
		if (errors.hasErrors()) {
			return "tpMyPage/modifyRegister.tiles";
		}
		String tpfId = (String) session.getAttribute("userLoginInfo");
		System.out.println(tpfId);

		TpFunder funder = service.findTpFunderById(tpfId);
		System.out.println(funder.toString());

		String p1 = request.getParameter("tpfPhoneNum1");
		String p2 = request.getParameter("tpfPhoneNum2");
		String p3 = request.getParameter("tpfPhoneNum3");

		funder.setTpfId(tpfId);
		funder.setTpfName(request.getParameter("tpfName"));
		funder.setTpfPassword(request.getParameter("tpfPassword"));

		funder.setTpfEmail(request.getParameter("tpfEmail"));
		funder.setTpfPhoneNum(p1 + "-" + p2 + "-" + p3);
		funder.setTpfZipcode(request.getParameter("tpfZipcode"));
		funder.setTpfAddress(request.getParameter("tpfAddress"));
		funder.setTpfAddressD(request.getParameter("tpfAddressD"));

		System.out.println(funder.toString());

		service.updateTpFunder(funder);
		model.addAttribute("tpfId", session.getAttribute("userLoginInfo"));
		return "tpMyPage/tpMyPageMain.tiles";

	}

	// 마이페이지 메인
	@RequestMapping("myPageMain")
	public String myPageMain(HttpSession session, @ModelAttribute TpFunder tpfunder, ModelMap model) throws Exception {
		model.addAttribute("tpfId", session.getAttribute("userLoginInfo"));
		return "tpMyPage/tpMyPageMain.tiles";
	}

	// 회원정보 추가
	//권한 업글
	@RequestMapping("addInfo")
	public String adddInfo(@ModelAttribute TpProposer tposer,HttpSession session, HttpServletRequest request, Errors errors) throws Exception {
		// 세션에서 아이디 불러옴
		String writer = (String) session.getAttribute("userLoginInfo");
		System.out.println(writer);
		
		// 값 넣어주기		
		
		tposer.setTpfId(writer);// 아이디
		tposer.setAccount(request.getParameter("account"));// 계좌
		tposer.setProposerType(request.getParameter("proposerType"));// 일반개인or법인or개인사업자
		tposer.setCertification("F");
		tposer.setResidentRegistrationFirstNum(request.getParameter("residentRegistrationFirstNum"));// 주민번호
																				// 앞자리
		tposer.setResidentRegistrationLastNum(request.getParameter("residentRegistrationLastNum"));// 주민번호
																			// 뒷자리
		tposer.setCorporateRegistrationNumber(request.getParameter("corporateRegistrationNumber"));// 사업자번호
		
		
		
		System.out.println(tposer.toString());

		TpProposerValidator validate = new TpProposerValidator();
		validate.validate(tposer, errors);
		
		System.out.println("프로퍼저 등록 검증 에러필드 개수 : "+errors.getErrorCount());
		if(errors.hasErrors()){
			return "tpMyPage/tpProposer.tiles";
		}
		System.out.println("프로퍼저 벨리데이션 통과");
		
		service.addProposerInfo(tposer, writer);

		
		TpFunder tpFunder = service.findTpFunderById(writer);
		System.out.println(tpFunder.toString());
		return "tpMyPage/tpMyPageMain.tiles";
	}


	/**
	 * 회원탈퇴완료
	 * 
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("removeFunder")
	public String dropOutFunder(HttpSession session) throws Exception {
		System.out.println(session.getAttribute("userLoginInfo"));
		String dropOutId = String.valueOf(session.getAttribute("userLoginInfo"));
		service.removeTpFunder(dropOutId);
		session.invalidate(); // 세션 삭제
		return "/main.tp";
	}

	/**
	 * 회원 탈퇴하기전 ID 및 비밀번호 체크
	 * 
	 * @param dropOutId
	 * @param dropOutPwd
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "dropOutFunder", method = RequestMethod.POST)
	@ResponseBody
	public String dropIdCheck(@RequestParam String dropOutId, @RequestParam String dropOutPwd, HttpSession session) {
		String txt = null;

		String Id = dropOutId;
		String Pwd = dropOutPwd;

		if (Id == null || Id.trim().length() == 0) {// 로그인 Id가 값이없을때
			txt = "잘못된 입력입니다";
		}
		try {// 로그인 ID가 DB에 존재 유무 확인
			String TpFunderId = (service.findTpFunderById(Id)).getTpfId();
			String TpFunderPwd = (service.findTpFunderById(Id)).getTpfPassword();
			if (Id.equals(TpFunderId) && Pwd.equals(TpFunderPwd)) { // ID 비밀번호확인
				txt = "success";// 입력한 ID와 비밀번호가 맞았음
			} else {// 비밀번호가 틀렸을경우
				txt = "비밀번호가 틀렸습니다";
			}
		} catch (NullPointerException e) {
			txt = "ID를 잘못 입력하셨습니다";
		}
		return txt;
	}
	/**
	 * 회원비밀번호 찾기
	 */
	@Autowired
	private EmailSender emailSender;
	@Autowired
	private Email email;
	@RequestMapping("mailPw")
	@ResponseBody
	public String sendEmailAction(@RequestParam String findId, @RequestParam String findEmail) throws Exception {
		String txt = null;
		String id = findId;
		String e_mail = findEmail;
		try {
			String tpfId = service.findTpFunderById(id).getTpfId();
			String tpfEmail = service.findTpFunderById(id).getTpfEmail();
			String pw = service.findTpFunderById(id).getTpfPassword();
			System.out.println(pw);
			if (id.equals(tpfId) && e_mail.equals(tpfEmail)) {
				if (pw != null) {
					email.setContent("비밀번호는 " + pw + " 입니다.");// 보낼 이메일 내용
					email.setReceiver(e_mail);// 받을 이메일 주소
					email.setSubject(id + "님 비밀번호 찾기 메일입니다.");// 이메일 제목
					emailSender.SendEmail(email);
					txt = "success";
				}
			} else {
				txt = "아이디와 이메일주소가 맞지 않습니다.";
			}
		} catch (NullPointerException e) {
			txt = "등록된 ID가 아닙니다.";
		}
		return txt;
	}
	//추가정보 입력창으로 이동
	@RequestMapping("Proposer")
	public String bankAllList(@ModelAttribute TpBankList lists, ModelMap model) {
		model.addAttribute("list", service.getAllBankList());
		System.out.println();
		return "tpMyPage/tpProposer.tiles";
	}
}

