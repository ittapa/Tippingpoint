package kr.pe.tippingpoint.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.pe.tippingpoint.service.TpNoticeService;
import kr.pe.tippingpoint.vo.TpFunder;
import kr.pe.tippingpoint.vo.TpNotice;

@Controller
public class TpNoticeController {
	
	@Autowired
	private TpNoticeService service;



	// 공지사항 전체보기(리스트)
	@RequestMapping("/tpNoticeBoard")
	public ModelAndView tpNoticeBoard (HttpServletRequest request) throws Exception{
		int pageNo = 1;
		try {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		} catch (Exception e) {
		}

		Map map = service.allListTpNotice(pageNo);
		
		return new ModelAndView("tpNotice/tpNoticeBoard.tiles", map);
	}
	// 공지사항 작성
	@RequestMapping(value="noticeWrite")
	public String tpNoticeWrite(TpNotice tpNotice, Errors errors, ModelMap model) throws Exception{
		
		System.out.println(tpNotice.getTpNoticeContents());
		
		if (errors.hasErrors()) {
			return "/tpNoticeBoard.tp";
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
	    Date current = new Date();
	    String strCurrent = sf.format(current);
		tpNotice.setTpNoticeDate(strCurrent);
	    service.tpNoticeWriter(tpNotice);
	    return "redirect:/tpAdminNoticeManager.tp";
	}

	// 공지사항 상세보기
	@RequestMapping("/findTpNotice")
	public ModelAndView findTpNotice(HttpServletRequest request) {

		String num = request.getParameter("tpNoticeNum");
		int tpNoticeNum = Integer.parseInt(num);
		TpNotice noticeList = service.findTpNoticeNum(tpNoticeNum);

		return new ModelAndView("tpNotice/tpNoticeView.tiles", "noticeList", noticeList);
	}
	
	// 관리자 공지사항 상세보기
	@RequestMapping("/adminFindTpNotice")
	public ModelAndView adminFindTpNotice(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String num = request.getParameter("tpNoticeNum");
		int tpNoticeNum = Integer.parseInt(num);
		TpNotice noticeList = service.findTpNoticeNum(tpNoticeNum);
		return new ModelAndView("tpAdministrator/tpAdminNoticeView.tiles", "noticeList", noticeList);
	}
	
	
	

	//관리자 공지사항 매니저
	@RequestMapping("/tpAdminNoticeManager")
	public ModelAndView tpAdminNoticeManager(HttpServletRequest request){
		int pageNo = 1;
		try {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		} catch (Exception e) {
		}

		Map map = service.allListTpNotice(pageNo);
		
		return new ModelAndView("tpAdministrator/tpAdminNoticeBoard.tiles", map);

	}
	
	//공지사항 삭제
	@RequestMapping("/removeNotice")
	public String removeNotice(HttpServletRequest request) throws Exception {
		int deleteNum = Integer.parseInt(request.getParameter("tpNoticeNum"));
		service.removeNotice(Integer.parseInt(request.getParameter("tpNoticeNum")));
		return "redirect:/tpAdminNoticeManager.tp";
	}
	
	//공지사항 수정보내기
	@RequestMapping("/modifyNotice")
	public ModelAndView modifyNoitce(HttpServletRequest request) throws Exception {
		int tpNoticeNum = Integer.parseInt(request.getParameter("tpNoticeNum"));
		TpNotice tpNotice  = service.findTpNoticeNum(tpNoticeNum);
		return new ModelAndView("tpAdministrator/tpAdminNoticeModify.tiles","tpNotice",tpNotice);
	}
	
	//공지사항 수정
	@RequestMapping("/updateNotice")
	public String updateNotice(@ModelAttribute TpNotice tpNotice, Errors errors, HttpSession session, HttpServletRequest request, ModelMap model){
		
		int tpNoticeNum = Integer.parseInt(request.getParameter("tpNoticeNum"));
		System.out.println(tpNoticeNum);
		TpNotice tpn = service.findTpNoticeNum(tpNoticeNum);
		TpNotice updateTpNotice = service.findTpNoticeNum(tpNoticeNum);
		
		
		updateTpNotice.setTpNoticeNum(tpNoticeNum);
		updateTpNotice.setTpNoticeTitle(request.getParameter("tpNoticeTitle"));
		updateTpNotice.setTpNoticeContents(request.getParameter("tpNoticeContents"));
		
		service.updateTpNotice(updateTpNotice);
		
		model.addAttribute("tpNoticeNum", tpNoticeNum);
		return "redirect:/adminFindTpNotice.tp";
	}
	
}
