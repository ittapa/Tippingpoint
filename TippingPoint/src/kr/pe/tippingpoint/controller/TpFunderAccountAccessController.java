package kr.pe.tippingpoint.controller;

import java.io.File;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.pe.tippingpoint.exception.DuplicatedIdException;
import kr.pe.tippingpoint.mail.Email;
import kr.pe.tippingpoint.mail.EmailSender;
import kr.pe.tippingpoint.service.TpAdministratorService;
import kr.pe.tippingpoint.service.TpFunderAccountAccessServiceImpl;
import kr.pe.tippingpoint.validator.TpFunderValidator;
import kr.pe.tippingpoint.validator.TpProposerValidator;
import kr.pe.tippingpoint.vo.TpBankList;
import kr.pe.tippingpoint.vo.TpFunder;
import kr.pe.tippingpoint.vo.TpProject;
import kr.pe.tippingpoint.vo.TpProposer;

/**
 * 회원 로그인 작업을 처리하는 Controller
 */
@Controller
public class TpFunderAccountAccessController {

	@Autowired
	private TpFunderAccountAccessServiceImpl service;

	@Autowired
	private TpAdministratorService adminservice;

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
	@RequestMapping("/registerTpFunder")
	public String registerTpFunder(@ModelAttribute TpFunder tpfunder,
			@RequestParam(required = false) MultipartFile upfile, HttpServletRequest request, Errors errors,
			ModelMap model, HttpSession session) throws DuplicatedIdException {

		tpfunder.setTpfQualifyTpProposer("F"); // 제안자 권한 false
		tpfunder.setTpfAccountType("D"); // 계정 유형 DEfault / F: facebook
		TpFunderValidator validate = new TpFunderValidator();
		validate.validate(tpfunder, errors); // ★

		if (errors.hasErrors()) {
			return "/tpfunder/registerForm.tp";
		}

		/////// 이미지 처리//////////
		String dftFilePath = request.getSession().getServletContext().getRealPath("/");
		String rootpath = request.getSession().getServletContext().getInitParameter("rootPath");

		if (upfile != null && !upfile.isEmpty()) {
			// 업로드된 파일의 정보를 조회
			// 파일을 임시저장경로에서 최종 저장경로로 이동
			String mainImgName = upfile.getOriginalFilename();
			long fileSize = upfile.getSize();
			System.out.println(mainImgName + "-" + fileSize); // todo

			// 신규 파일로 디렉토리 설정 및 업로드
			String filePath_1 = "resources" + "/" + "profile" + "/" + "mainImage" + "/";
			String filePath = dftFilePath + filePath_1;
			System.out.println("메인이미지 저장경로" + filePath); // todo

			File file = new File(filePath); // 메인이미지 저장경로 설정
			if (!file.exists()) {
				file.mkdirs();
			}

			long tileMilis = System.currentTimeMillis(); // 현재시간
			String realMainImgName = tpfunder.getTpfId() + tileMilis + mainImgName;
			System.out.println("main이미지 이름 저장되는 이름" + realMainImgName);

			File upImg = new File(filePath, realMainImgName); // 저장설정
			try {
				upfile.transferTo(upImg);
			} catch (IOException e) {
				e.printStackTrace();
			}
			tpfunder.setTpfProfileImg(rootpath + "/" + filePath_1 + realMainImgName); // upfile
		} else {
			if (tpfunder.getTpfProfileImg() == null) {
				tpfunder.setTpfProfileImg(rootpath + "/defaultImg/tpProjectDefault.png");
			}

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
	public String modifyRegister(@ModelAttribute TpFunder tpfunder,
			@RequestParam(required = false) MultipartFile upfile, Errors errors, ModelMap model, HttpSession session,
			HttpServletRequest request) throws Exception {
		TpFunderValidator validate = new TpFunderValidator();
		validate.validate(tpfunder, errors);
		if (errors.hasErrors()) {
			System.out.println(errors);
			return "tpMyPage/modifyRegister.tiles";
		}

		String tpfId = (String) session.getAttribute("userLoginInfo");

		// TpFunder funder = service.findTpFunderById(tpfId);

		String p1 = request.getParameter("tpfPhoneNum1");
		String p2 = request.getParameter("tpfPhoneNum2");
		String p3 = request.getParameter("tpfPhoneNum3");

		tpfunder.setTpfId(tpfId);
		tpfunder.setTpfPhoneNum(p1 + "-" + p2 + "-" + p3);

		// funder.setTpfName(request.getParameter("tpfName"));
		// funder.setTpfPassword(request.getParameter("tpfPassword"));

		// funder.setTpfEmail(request.getParameter("tpfEmail"));
		// funder.setTpfZipcode(request.getParameter("tpfZipcode"));
		// funder.setTpfAddress(request.getParameter("tpfAddress"));
		// funder.setTpfAddressD(request.getParameter("tpfAddressD"));
		// funder.setTpfProfileImg(request.getParameter("tpfProfileImg"));

		/////// 이미지 처리//////////
		String dftFilePath = request.getSession().getServletContext().getRealPath("/");
		String rootpath = request.getSession().getServletContext().getInitParameter("rootPath");

		if (upfile != null && !upfile.isEmpty()) {
			// 업로드된 파일의 정보를 조회
			// 파일을 임시저장경로에서 최종 저장경로로 이동
			String mainImgName = upfile.getOriginalFilename();
			long fileSize = upfile.getSize();
			System.out.println(mainImgName + "-" + fileSize); // todo

			// 신규 파일로 디렉토리 설정 및 업로드
			String filePath_1 = "resources" + "/" + "profile" + "/" + "mainImage" + "/";
			String filePath = dftFilePath + filePath_1;
			System.out.println("메인이미지 저장경로" + filePath); // todo

			File file = new File(filePath); // 메인이미지 저장경로 설정
			if (!file.exists()) {
				file.mkdirs();
			}

			long tileMilis = System.currentTimeMillis(); // 현재시간
			String realMainImgName = tpfunder.getTpfId() + tileMilis + mainImgName;
			System.out.println("main이미지 이름 저장되는 이름" + realMainImgName);

			File upImg = new File(filePath, realMainImgName); // 저장설정
			upfile.transferTo(upImg);
			tpfunder.setTpfProfileImg(rootpath + "/" + filePath_1 + realMainImgName); // upfile

		} else {
			System.out.println(tpfunder.getTpfProfileImg());
			if (tpfunder.getTpfProfileImg().equals("default")) {
				tpfunder.setTpfProfileImg(rootpath + "/defaultImg/tpProjectDefault.png");
			}

		}

		service.updateTpFunder(tpfunder);
		model.addAttribute("tpfId", session.getAttribute("userLoginInfo"));
		return "tpMyPage/tpMyPageMain.tiles";

	}

	// 마이페이지 메인
	@RequestMapping("myPageMain")
	public String myPageMain(HttpSession session, @ModelAttribute TpFunder tpfunder, ModelMap model) throws Exception {
		String tfId = (String) session.getAttribute("userLoginInfo");
		TpFunder funder = service.findTpFunderById(tfId);
		String qualify = funder.getTpfQualifyTpProposer();
		System.out.println(qualify);

		int num = 0;
		if (qualify.equals("T")) {
			num = 0;
		} else {
			num = 1;
		}
		System.out.println(num);

		model.addAttribute("num", num);
		model.addAttribute("tpfId", session.getAttribute("userLoginInfo"));
		return "tpMyPage/tpMyPageMain.tiles";
	}

	// 회원정보 추가
	// 새롭게 권한 업글
	@RequestMapping("addInfoProposer")
	public String adddInfo(@ModelAttribute TpProposer tpProposer, HttpSession session, HttpServletRequest request,
			Errors errors, ModelMap model) throws Exception {
		// 세션에서 아이디 불러옴
		String tpfid = (String) session.getAttribute("userLoginInfo");
		System.out.println(tpfid);
		tpProposer.setTpfId(tpfid);
		System.out.println(tpProposer.toString());

		TpProposerValidator validate = new TpProposerValidator();
		validate.validate(tpProposer, errors);

		System.out.println("프로퍼저 등록 검증 에러필드 개수 : " + errors.getErrorCount());
		if (errors.hasErrors()) {
			model.addAttribute("num", 1);
			model.addAttribute("proposer", tpProposer);
			model.addAttribute("errorMessage", "Proposer 권한등록에 실패했습니다.");
			model.addAttribute("bankList", service.getAllBankList());

			return "tpMyPage/tpProposer.tiles";
		}
		System.out.println("프로퍼저 벨리데이션 통과");

		service.addProposerInfo(tpProposer, tpfid);

		TpFunder tpFunder = service.findTpFunderById(tpfid);
		model.addAttribute("num", 0);
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
	public String sendEmailPassword(@RequestParam String findId, @RequestParam String findName,
			@RequestParam String findEmail, @RequestParam String findBirth) throws Exception {
		String txt = null;
		String id = findId;
		String name = findName;
		String e_mail = findEmail;
		String birth = findBirth;

		try {
			String tpfId = service.findTpFunderById(id).getTpfId();
			String tpfName = service.findTpFunderById(id).getTpfName();
			String tpfEmail = service.findTpFunderById(id).getTpfEmail();
			String tpfBirth = service.findTpFunderById(id).getTpfBirth();
			String pw = service.findTpFunderById(id).getTpfPassword();

			String fpw = "";// 비밀번호 뒷자리 3개를 *로 변경
			char[] password = pw.toCharArray();
			for (int i = 0; i < (password.length - 3); i++) {
				fpw += password[i];
			}
			fpw = fpw + "***";

			System.out.println(pw);
			if (id.equals(tpfId) && name.equals(tpfName) && e_mail.equals(tpfEmail) && birth.equals(tpfBirth)) {
				if (pw != null) {
					email.setContent("비밀번호는 " + fpw + " 입니다.");// 보낼 이메일 내용
					email.setReceiver(e_mail);// 받을 이메일 주소
					email.setSubject(name + "님 비밀번호 찾기 메일입니다.");// 이메일 제목
					emailSender.SendEmail(email); // 보내는 email
					txt = "success";
				}
			} else {
				txt = "회원정보가 맞지 않습니다.";
			}
		} catch (NullPointerException e) {
			txt = "등록된 ID가 아닙니다.";
		}
		return txt;
	}

	// 추가정보 입력창으로 이동
	// 추가정보 입력창 또는 수정창으로 이동
	@RequestMapping("tpProposer")
	public String bankAllList(ModelMap model, HttpSession session) {
		String tpfId = (String) session.getAttribute("userLoginInfo");
		TpFunder funder = service.findTpFunderById(tpfId);
		String qualify = funder.getTpfQualifyTpProposer();
		System.out.println(qualify);

		int num = 0;
		if (qualify.equals("T")) {
			num = 0;
			model.addAttribute("proposer", service.selectTpProposerById(tpfId));
		} else {
			num = 1;
		}
		System.out.println(num);
		model.addAttribute("num", num);
		model.addAttribute("bankList", service.getAllBankList());
		System.out.println();
		return "tpMyPage/tpProposer.tiles";
	}

	@RequestMapping("/updateInfoProposer")
	public String updateInfo(@ModelAttribute TpProposer proposer, HttpSession session, HttpServletRequest request,
			Errors errors, ModelMap model) throws Exception {

		String tpfId = (String) session.getAttribute("userLoginInfo");
		System.out.println(tpfId);
		proposer.setTpfId(tpfId);// 아이디

		System.out.println(proposer.toString());

		TpProposerValidator validate = new TpProposerValidator();
		validate.validate(proposer, errors);

		System.out.println("프로퍼저 등록 검증 에러필드 개수 : " + errors.getErrorCount());
		if (errors.hasErrors()) {
			model.addAttribute("num", 0);
			model.addAttribute("proposer", proposer);
			model.addAttribute("errorMessage", "정보 수정에 실패했습니다.");
			model.addAttribute("bankList", service.getAllBankList());
			return "tpMyPage/tpProposer.tiles";
		}
		System.out.println("프로퍼저 벨리데이션 통과");

		service.updateInfo(proposer);

		model.addAttribute("proposer", proposer);
		model.addAttribute("num", 0);

		return "tpMyPage/tpMyPageMain.tiles";

	}

	/**
	 * 회원ID찾기
	 */
	@RequestMapping("mailId")
	@ResponseBody
	public String sendEmailId(@RequestParam String findPhoneNum, @RequestParam String findEmail,
			@RequestParam String findBirth) throws Exception {
		String txt = null;
		String phoneNum = findPhoneNum;
		String e_mail = findEmail;
		String birth = findBirth;

		try {
			String tpfName = service.findTpFunderByPhoneNum(phoneNum).getTpfName();
			String tpfEmail = service.findTpFunderByPhoneNum(phoneNum).getTpfEmail();
			String tpfBirth = service.findTpFunderByPhoneNum(phoneNum).getTpfBirth();
			String tpfId = service.findTpFunderByPhoneNum(phoneNum).getTpfId();
			String tpfPhoneNum = service.findTpFunderByPhoneNum(phoneNum).getTpfPhoneNum();
			if (phoneNum.equals(tpfPhoneNum) && e_mail.equals(tpfEmail) && birth.equals(tpfBirth)) {
				if (tpfId != null) {
					email.setContent("아이디는 " + tpfId + " 입니다.");// 보낼 이메일 내용
					email.setReceiver(e_mail);// 받을 이메일 주소
					email.setSubject(tpfName + "님 아이디찾기 메일입니다.");// 이메일 제목
					emailSender.SendEmail(email); // 보내는 email
					txt = "success";
				}
			} else {
				txt = "회원정보가 맞지 않습니다.";
			}
		} catch (NullPointerException e) {
			txt = "등록된 회원이 아닙니다.";
		}
		return txt;
	}

	// 프로젝트 종료
	@RequestMapping("tpProjectExit")
	public String tpAdminUp(HttpServletRequest request, HttpSession session) {

		String tppId = request.getParameter("tppId");
		String tppState = request.getParameter("tppState");
		String tppAdminMessage = "프로젝트가 종료되었습니다.";
		TpProject adminProject = new TpProject();
		adminProject.setTppAdminMessage(tppAdminMessage);
		adminProject.setTppId(tppId);
		adminProject.setTppState(tppState);

		adminservice.adminProjectUp(adminProject);

		return "tpMyPage/tpMyPageMain.tiles";
	}

}
