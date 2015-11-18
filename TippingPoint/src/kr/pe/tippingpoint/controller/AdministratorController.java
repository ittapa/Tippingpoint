package kr.pe.tippingpoint.controller;

import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.pe.tippingpoint.service.TpAdministratorService;
import kr.pe.tippingpoint.service.TpProjectService;
import kr.pe.tippingpoint.vo.TpProject;

@Controller
public class AdministratorController {

	
	@Autowired
	private TpAdministratorService adminservice;

	@RequestMapping("/tpAdminLogin")
	public String tpAdminLogin(HttpServletRequest request, HttpServletResponse response){
		String id = "id";
		String pw = "pw";
		String adminId = request.getParameter("adminId");
		String adminPw = request.getParameter("adminPw");
		
		if(!id.equals(adminId)){
			return "/admincheck.jsp";
		}
		
		if(!pw.equals(adminPw)){
			return "/admincheck.jsp";
		}
		
		return "/WEB-INF/view/body/tpAdministrator/adminmain.jsp";
		
	}
	

	// 프로젝트 전체보기
	@RequestMapping("/tpAdminProjectBoard")
	public ModelAndView tpAdminProjectBoard(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int pageNo = 1;
		try {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			
		} catch (Exception e) {
		}

		Map map = adminservice.adminAllListTpProject(pageNo);
		System.out.println("메롱2");
		

		return new ModelAndView("/WEB-INF/view/body/tpAdministrator/adminProjectList.jsp", map);
	}
	

	// 단일 프로젝트 조회하기
	@RequestMapping("/tpAdminFindTpProject")
	public ModelAndView tpAdminFindTpProject(HttpServletRequest request, HttpServletResponse response) {

		// 1.요청파라미터 조회

		String tppId = request.getParameter("tppId");
		TpProject polist = adminservice.adminFindTpProjectById(tppId);

		return new ModelAndView("/WEB-INF/view/body/tpAdministrator/adminview.jsp", "polist", polist);
	}
	
	
	//프로젝트 승인
	@RequestMapping("tpAdminUp")
	public String tpAdminUp(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("tppId");
		String tppState = request.getParameter("tppState");
		String tppAdminMessage = request.getParameter("tppAdminMessage");		
		TpProject adminProject = new TpProject();
		adminProject.setTppAdminMessage(tppAdminMessage);
		adminProject.setTppId(id);
		adminProject.setTppState(tppState);
		
		adminservice.adminProjectUp(adminProject);
		
		return "/WEB-INF/view/body/tpAdministrator/adminProjectList.jsp";
	}
}
