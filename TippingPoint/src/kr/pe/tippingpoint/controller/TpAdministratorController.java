package kr.pe.tippingpoint.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.pe.tippingpoint.service.TpAdministratorService;
import kr.pe.tippingpoint.service.TpFunderAccountAccessService;
import kr.pe.tippingpoint.service.TpNoticeService;
import kr.pe.tippingpoint.service.TpNoticeServiceImpl;
import kr.pe.tippingpoint.service.TpProjectService;
import kr.pe.tippingpoint.vo.TpBankList;
import kr.pe.tippingpoint.vo.TpFunder;
import kr.pe.tippingpoint.vo.TpNotice;
import kr.pe.tippingpoint.vo.TpProject;
import kr.pe.tippingpoint.vo.TpProjectCategory;

@Controller
public class TpAdministratorController {

	@Autowired
	private TpAdministratorService adminservice;

	@Autowired
	private TpFunderAccountAccessService service;

	@Autowired
	private TpProjectService projectservice;
	// 관리자 로그인..
	@RequestMapping(value = "/tpAdminLogin", method = RequestMethod.POST)
	public ModelAndView tpAdminLogin(HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String adId = "admin";
		String adPd = "admin";
		if (!"admin".equals(adId)) {
			System.out.println("아이디안맞음");
			mav.setViewName("tpAdministrator/tpAdminAccess.tiles");
			
		}
		if (!"admin".equals(adPd)) {
			System.out.println("비밀번호 안맞음");
			mav.setViewName("tpAdministrator/tpAdminAccess.tiles");
			
		}
		session.setAttribute("adminId", adId);
		mav.setViewName("tpAdministrator/tpAdminMain.tp");
		return mav;
	}

	// 프로젝트 전체보기
	@RequestMapping("/tpAdminProjectBoard")
	public String tpAdminProjectBoard(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			HttpSession session) throws Exception {

		int pageNo = 1;
		try {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));

		} catch (Exception e) {
		}

		Map map = adminservice.adminAllListTpProject(pageNo);
		model.addAllAttributes(map);

		return "tpAdministrator/tpAdminProjectBoard.tiles";
	}

	// 프로젝트 상세보기 (단일프로젝트조회)
	@RequestMapping("/tpAdminFindTpProject")
	public String tpAdminFindTpProject(HttpServletRequest request, HttpSession session, ModelMap model) {

		// 1.요청파라미터 조회
		String tppId = request.getParameter("tppId");
		TpProject polist = adminservice.adminFindTpProjectById(tppId);
		model.addAttribute("polist", polist);
		return "tpAdministrator/tpAdminProject.tiles";

	}

	// 프로젝트 승인
	@RequestMapping("tpAdminProjectStateConvert")
	public String tpAdminUp(HttpServletRequest request, HttpSession session) {

		String tppId = request.getParameter("tppId");
		String tppState = request.getParameter("tppState");
		String tppAdminMessage = request.getParameter("tppAdminMessage");
		TpProject adminProject = new TpProject();
		adminProject.setTppAdminMessage(tppAdminMessage);
		adminProject.setTppId(tppId);
		adminProject.setTppState(tppState);

		adminservice.adminProjectUp(adminProject);

		return "tpAdminProjectBoard.tp";
	}

	// 관리자 체크 페이지 - 관리자 메인으로 이동
	@RequestMapping("/adminCheckAndMain")
	public String tpAdminCheck(HttpSession session) {

		return "tpAdministrator/tpAdminMain.tiles";
	}

	////////////////////////////////////////////////// 회원관리처리////////////////////////////////////////////////////////////////

	// 관리자 전체회원조회
	@RequestMapping("/findAllTpFunderList")
	public String findAllTpFunderList(@RequestParam(defaultValue = "1") String pageNo, ModelMap model,
			HttpSession session) {

		int page = 1;
		try {
			page = Integer.parseInt(pageNo); // null일 경우 예외처리를 통해 page를 1로
												// 처리한다..
		} catch (NumberFormatException e) {
		}

		Map attributes = service.getAllTpFundersPaging(page);
		model.addAllAttributes(attributes);
		return "tpAdministrator/tpAdminfunderList.tiles";
	}

	// 관리자 Id로 회원 조회 메소드
	@RequestMapping("/findByTpfId")
	public String findByTpfId(@RequestParam String tpfId, ModelMap model, HttpSession session) {

		TpFunder tpFunder = service.findTpFunderById(tpfId);
		model.addAttribute("tpFunder", tpFunder);
		return "tpAdministrator/tpFunderInfo.tiles";
	}

	// 어드민 카테고리별 보기
	@RequestMapping("/tpAdminCategoryProjectBoard")

	public String tpAdminCategoryProjectBoard(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			HttpSession session) throws Exception {

		int pageNo = 1;

		try {

			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		} catch (Exception e) {

		}

		String check = request.getParameter("check");

		Map map = adminservice.adminCategoryProject(pageNo, check);

		model.addAllAttributes(map);

		return "tpAdministrator/tpAdminProjectBoard.tiles";

	}

	///////////////////////////////////////////// 관리자 카테고리
	///////////////////////////////////////////// 관리////////////////////////////////////////////
	// 관리자 체크 페이지 - 카테고리 관리 메인으로 이동
	@RequestMapping("/tpAdminCheckAndCategoryMain")
	public String tpAdminCheckAndCategoryMain(HttpSession session) {
		return "tpAdministrator/tpAdminCategoryMain.tiles";
	}

	// 카테고리 추가,수정 삭제 페이지로 이동
	@RequestMapping("/catrgoryController")
	public String catrgoryController(HttpSession session, HttpServletRequest request, ModelMap model) {

		String controll = request.getParameter("controll");
		model.addAttribute("list", projectservice.tpProjectCategoryList());

		if (controll.equals("add")) {
			return "tpAdministrator/tpAdminAddCategory.tiles";
		}
		if (controll.equals("delete")) {
			return "tpAdministrator/tpAdminDeleteCategory.tiles";
		}
		if (controll.equals("update")) {
			return "tpAdministrator/tpAdminUpdateCategory.tiles";
		}

		return "tpAdministrator/tpAdminCategoryMain.tiles";
	}

	// 관리자 - 카테고리 추가 메소드
	@RequestMapping("insertCategory")
	public String insertCategory(HttpServletRequest request, HttpSession session) {
		String tppCategory = request.getParameter("tppCategory");
		String tppCategoryName = request.getParameter("tppCategoryName");
		adminservice.addTpCategory(tppCategory, tppCategoryName);

		return "tpAdministrator/tpAdminCategoryMain.tiles";
	}

	// 관리자 - 카테고리 삭제 메소드
	@RequestMapping("deleteCategory")
	public String deleteCategory(HttpServletRequest request, HttpSession sessionn) {
		String tppCategoryName = request.getParameter("tppCategoryName");
		System.out.println(tppCategoryName);
		adminservice.deleteTpCategory(tppCategoryName);

		return "tpAdministrator/tpAdminCategoryMain.tiles";
	}

	// 관리자 - 카테고리 수정 메소드
	@RequestMapping("updateCategory")
	public String updateCategory(HttpServletRequest request, HttpSession session) {
		String tppCategory = request.getParameter("tppCategory");
		String tppCategoryName = request.getParameter("tppCategoryName");
		String updateCategory = request.getParameter("updateCategory");

		TpProjectCategory category = new TpProjectCategory();
		category.setTppCategory(tppCategory);
		category.setTppCategoryName(tppCategoryName);

		adminservice.updateTpCategory(category, updateCategory);

		return "tpAdministrator/tpAdminCategoryMain.tiles";
	}

	//////////////////////////////////////////////////// 은행
	//////////////////////////////////////////////////// Page//////////////////////////////////////////
	// 은행 관리 - Main으로 이동
	@RequestMapping("/tpAdminCheckAndBankMain")
	public String tpAdminCheckAndBankMain(HttpSession session) {

		return "tpAdministrator/tpAdminBankMain.tiles";
	}

	// 은행 추가,수정 삭제 페이지로 이동
	@RequestMapping("/bankController")
	public String bankController(HttpSession session, HttpServletRequest request, ModelMap model) {

		String controll = request.getParameter("controll");
		model.addAttribute("list", service.getAllBankList());

		if (controll.equals("add")) {
			return "tpAdministrator/tpAdminAddBank.tiles";
		}
		if (controll.equals("delete")) {
			return "tpAdministrator/tpAdminDeleteBank.tiles";
		}
		if (controll.equals("update")) {
			return "tpAdministrator/tpAdminUpdateBank.tiles";
		}

		return "tpAdministrator/tpAdminBankMain.tiles";
	}

	// 은행 - 카테고리 추가 메소드
	@RequestMapping("insertBank")
	public String insertBank(HttpServletRequest request, HttpSession session) {

		String bankKr = request.getParameter("bankKr");
		String bankEr = request.getParameter("bankEr");
		String code = request.getParameter("code");
		adminservice.addBank(bankKr, bankEr, code);

		return "tpAdministrator/tpAdminBankMain.tiles";
	}

	// 은행 - 카테고리 삭제 메소드
	@RequestMapping("deleteBank")
	public String deleteBank(HttpServletRequest request, HttpSession session) {

		String bankKr = request.getParameter("bankKr");
		adminservice.deleteBank(bankKr);

		return "tpAdministrator/tpAdminBankMain.tiles";
	}

	// 은행 - 카테고리 수정 메소드
	@RequestMapping("updateBank")
	public String updateBank(HttpServletRequest request, HttpSession session) {

		String updateBank = request.getParameter("updateBank");
		String bankKr = request.getParameter("bankKr");
		String bankEr = request.getParameter("bankEr");
		String code = request.getParameter("code");

		TpBankList bankList = new TpBankList();
		bankList.setBankKr(bankKr);
		bankList.setBankEr(bankEr);
		bankList.setCode(code);
		adminservice.updateBank(updateBank, bankList);

		return "tpAdministrator/tpAdminBankMain.tiles";
	}

}
