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
import kr.pe.tippingpoint.service.TpFunderAccountAccessServiceImpl;
import kr.pe.tippingpoint.validator.TpFunderValidator;
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
			if (loginId.equals(TpFunderId) && loginPwd.equals(TpFunderPwd)) { // 로그인 및 ID 비밀번호확인
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
		String  backpage = String.valueOf(session.getAttribute("backpage"));
		System.out.println(backpage);
		mav.setViewName(backpage);
		return mav;
	}
	
	/**
	 *누가봐도 로그아웃 
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

		tpfunder.setTpfQualifyTpProposer("true");
		tpfunder.setTpfAccountType("f");
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
	 * @param tpfId
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("modifyForm")
	public String modifyForm(HttpSession session, ModelMap model) throws Exception{
		String userid = (String) session.getAttribute("userLoginInfo");
		TpFunder funder = service.findTpFunderById(userid);
				
		String list = funder.getTpfPhoneNum();
		String[] str = list.split("\\-");
		
		model.addAttribute("tpFunder", funder);
		model.addAttribute("tpfPhoneNum2",str[1]);
		model.addAttribute("tpfPhoneNum3",str[2]);
		System.out.println();
		return "tpMyPage/modifyRegister.tiles";
	}
	
	/**
	 * 회원수정
	 * @param tpfunder
	 * @param errors
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("funderModifyRegister")
	public String modifyRegister(@ModelAttribute TpFunder tpfunder, Errors errors, ModelMap model, HttpSession session,
			HttpServletRequest request) throws Exception {
		System.out.println("와써");
		String tpfId = (String) session.getAttribute("userLoginInfo");
		System.out.println(tpfId);

		TpFunder funder = service.findTpFunderById(tpfId);
		System.out.println(funder.toString());

		System.out.println("와써??");
		String p1 = request.getParameter("tpfPhoneNum1");
		String p2 = request.getParameter("tpfPhoneNum2");
		String p3 = request.getParameter("tpfPhoneNum3");

		funder.setTpfId(tpfId);
		funder.setTpfName(request.getParameter("tpfName"));
		funder.setTpfPassword(request.getParameter("tpfPassword"));

		funder.setTpfEmail(request.getParameter("tpfEmail"));
		funder.setTpfPhoneNum(p1+ "-" + p2+ "-" + p3);
		funder.setTpfZipcode(request.getParameter("tpfZipcode"));
		funder.setTpfAddress(request.getParameter("tpfAddress"));
		funder.setTpfAddressD(request.getParameter("tpfAddressD"));

		System.out.println(funder.toString());

		service.updateTpFunder(funder);
		model.addAttribute("tpfId", session.getAttribute("userLoginInfo"));
		return "tpMyPage/tpMyPageMain.tiles";

	}
	
	//마이페이지 메인
	@RequestMapping("myPageMain")
	public String myPageMain(HttpSession session, @ModelAttribute TpFunder tpfunder, ModelMap model) throws Exception{
		model.addAttribute("tpfId", session.getAttribute("userLoginInfo"));
		return "tpMyPage/tpMyPageMain.tiles";
	}

	
	
	//회원정보 추가 
	@RequestMapping("addInfo")
	public String adddInfo(HttpSession session, HttpServletRequest request) throws Exception{
		//세션에서 아이디 불러옴
		String writer = (String) session.getAttribute("userLoginInfo");
		System.out.println(writer);
		int residentRegistrationFirstNum = Integer.parseInt(request.getParameter("residentRegistrationFirstNum"));
		int residentRegistrationLastNum = Integer.parseInt(request.getParameter("residentRegistrationLastNum"));
		int corporateRegistrationNumber = Integer.parseInt(request.getParameter("corporateRegistrationNumber"));
		//값 넣어주기
		TpProposer tposer = new TpProposer();
		tposer.setTpfId(writer);//아이디
		tposer.setAccount(request.getParameter("account"));//계좌
		tposer.setProposerType(request.getParameter("proposerType"));//일반개인or법인or개인사업자
		tposer.setCertification("F");
		tposer.setResidentRegistrationFirstNum(residentRegistrationFirstNum);//주민번호 앞자리
		tposer.setResidentRegistrationLastNum(residentRegistrationLastNum);//주민번호 뒷자리
		tposer.setCorporateRegistrationNumber(corporateRegistrationNumber);//사업자번호
		System.out.println(tposer.toString());
		
		
		service.addProposerInfo(tposer);
		
			
		return "tpMyPage/tpMyPageMain.tiles";
	}
}

