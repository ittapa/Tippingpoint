package kr.pe.tippingpoint.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.pe.tippingpoint.service.TpAdministratorService;
import kr.pe.tippingpoint.service.TpFunderAccountAccessService;
import kr.pe.tippingpoint.vo.TpFunder;
import kr.pe.tippingpoint.vo.TpProject;

@Controller
public class TpAdministratorController {

	@Autowired
	private TpAdministratorService adminservice;

	@Autowired
	private TpFunderAccountAccessService service;

	// 관리자 로그인..
	@RequestMapping("/tpAdminLogin")
	public String tpAdminLogin(HttpServletRequest request, HttpServletResponse response) {
		String id = "id";
		String pw = "pw";
		String adminId = request.getParameter("adminId");
		String adminPw = request.getParameter("adminPw");

		if (!id.equals(adminId)) {
			return "/tpAdminCheck.jsp";
		}

		if (!pw.equals(adminPw)) {
			return "/tpAdminCheck.jsp";
		}

		return "tpAdministrator/tpAdminMain.tiles";

	}

	// 프로젝트 전체보기
	@RequestMapping("/tpAdminProjectBoard")
	public ModelAndView tpAdminProjectBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int pageNo = 1;
		try {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));

		} catch (Exception e) {
		}

		Map map = adminservice.adminAllListTpProject(pageNo);
		System.out.println("메롱2");

		return new ModelAndView("tpAdministrator/tpAdminProjectBoard.tiles", map);
	}

	// 단일 프로젝트 조회하기
	@RequestMapping("/tpAdminFindTpProject")
	public ModelAndView tpAdminFindTpProject(HttpServletRequest request) {

		// 1.요청파라미터 조회
		String tppId = request.getParameter("tppId");
		TpProject polist = adminservice.adminFindTpProjectById(tppId);

		return new ModelAndView("/WEB-INF/view/body/tpAdministrator/tpAdminProject.jsp", "polist", polist);
	}

	// 프로젝트 승인
	@RequestMapping("tpAdminProjectStateConvert")
	public String tpAdminUp(HttpServletRequest request) {
		String id = request.getParameter("tppId");
		String tppState = request.getParameter("tppState");
		String tppAdminMessage = request.getParameter("tppAdminMessage");
		TpProject adminProject = new TpProject();
		adminProject.setTppAdminMessage(tppAdminMessage);
		adminProject.setTppId(id);
		adminProject.setTppState(tppState);

		adminservice.adminProjectUp(adminProject);

		return "/tpAdminProjectBoard.tp";
	}

	// 관리자 전체회원조회
	@RequestMapping("/findAllTpFunderList")
	public String findAllTpFunderList(@RequestParam(defaultValue = "1") String pageNo, ModelMap model) {
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
	public String findByTpfId(@RequestParam String tpfId, ModelMap model) {
		TpFunder tpFunder = service.findTpFunderById(tpfId);
		model.addAttribute("tpFunder", tpFunder);
		return "tpAdministrator/tpFunderInfo.tiles";
	}
	
}
