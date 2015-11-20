package kr.pe.tippingpoint.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.pe.tippingpoint.service.TpNoticeService;
import kr.pe.tippingpoint.vo.TpNotice;

@Controller
public class TpNoticeController {
	

	@Autowired
	private TpNoticeService service;



	// 공지사항 전체보기(리스트)
	@RequestMapping("/tpNoticeBoard")
	public ModelAndView tpNoticeBoard (HttpServletRequest request, HttpServletResponse response) throws Exception{
		int pageNo = 1;
		try {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		} catch (Exception e) {
		}

		Map map = service.allListTpNotice(pageNo);
		
		return new ModelAndView("/WEB-INF/view/body/tpNotice/tpNoticeBoard.jsp", map);
	}
	
	
	

	// 공지사항 상세보기
	@RequestMapping("/findTpNotice")
	public ModelAndView findTpNotice(HttpServletRequest request, HttpServletResponse response) {

		// 1.요청파라미터 조회

		String num = request.getParameter("tpNoticeNum");
		int tpNoticeNum = Integer.parseInt(num);
		TpNotice noticeList = service.findTpNoticeNum(tpNoticeNum);

		return new ModelAndView("/WEB-INF/view/body/tpNotice/tpNoticeView.jsp", "noticeList", noticeList);
	}


}
