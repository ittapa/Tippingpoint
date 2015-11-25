package kr.pe.tippingpoint.controller;

import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	private String id = "id";
	private String pw = "pw";

	// 관리자 로그인..
	@RequestMapping("/tpAdminLogin")
	public String tpAdminLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String adId = request.getParameter("adminId");
		String adPd = request.getParameter("adminPw");

		if (!id.equals(adId)) {
			return "tpAdministrator/tpAdminAccess.tiles";
		}

		if (!pw.equals(adPd)) {
			return "tpAdministrator/tpAdminAccess.tiles";
		}

		session.setAttribute("adminId", id);
		String adid = (String) session.getAttribute("adminId");
		System.out.println(adid);
		
		
		return "tpAdministrator/tpAdminMain.tiles";

	}

	// 프로젝트 전체보기
	@RequestMapping("/tpAdminProjectBoard")
	public String tpAdminProjectBoard(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model, HttpSession session) throws Exception {
		String adId = (String) session.getAttribute("adminId");
				
		if (!id.equals(adId)) {
			return "tpAdministrator/tpAdminAccess.tiles";
		}
		
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
		String adId = (String) session.getAttribute("adminId");
		
		if (!id.equals(adId)) {
			return "tpAdministrator/tpAdminAccess.tiles";
		}
		
		// 1.요청파라미터 조회
		String tppId = request.getParameter("tppId");
		TpProject polist = adminservice.adminFindTpProjectById(tppId);
		model.addAttribute("polist", polist);
		return "tpAdministrator/tpAdminProject.tiles";
		
	}

	// 프로젝트 승인
	@RequestMapping("tpAdminProjectStateConvert")
	public String tpAdminUp(HttpServletRequest request, HttpSession session) {
		String adId = (String) session.getAttribute("adminId");
		
		if (!id.equals(adId)) {
			return "tpAdministrator/tpAdminAccess.tiles";
		}
		
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
	
	//관리자 체크 페이지 - 관리자 메인으로 이동
	
	@RequestMapping("/adminCheckAndMain")
	public String tpAdminCheck(HttpSession session){
	String adId = (String) session.getAttribute("adminId");
		
		if (!id.equals(adId)) {
			return "tpAdministrator/tpAdminAccess.tiles";
		}
		
		return "tpAdministrator/tpAdminMain.tiles";
	}
	
	
//////////////////////////////////////////////////회원관리처리////////////////////////////////////////////////////////////////	
	
	
	// 관리자 전체회원조회
	@RequestMapping("/findAllTpFunderList")
	public String findAllTpFunderList(@RequestParam(defaultValue = "1") String pageNo, ModelMap model, HttpSession session) {
		String adId = (String) session.getAttribute("adminId");
		
		if (!id.equals(adId)) {
			return "tpAdministrator/tpAdminAccess.tiles";
		}
			
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
		String adId = (String) session.getAttribute("adminId");
		
		if (!id.equals(adId)) {
			return "tpAdministrator/tpAdminAccess.tiles";
		}
		
		TpFunder tpFunder = service.findTpFunderById(tpfId);
		model.addAttribute("tpFunder", tpFunder);
		return "tpAdministrator/tpFunderInfo.tiles";
	}
	
}

