package kr.pe.tippingpoint.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pay/")
public class tpPaymentController {

	@RequestMapping("payRequest.tp")
	public String payRequest(@RequestParam String tppPayType, @RequestParam String tppId, @RequestParam int tpAmount, HttpServletRequest request, ModelMap model){
		HttpSession session = request.getSession();
		String strUserId = (String)session.getAttribute("userLoginInfo");
		
		// TODO: 세션 처리되는 페이지 통합시 테스트 코드 삭제
		strUserId = "asdf";
		
		String strView = "/WEB-INF/view/body/tpPayment/";
		if(tppPayType == "p"){ // 현금 계좌이체
			strView = "";
		} else { // card
			strView = "/WEB-INF/view/body/tpPayment/payReq.jsp";
		}
		
		System.out.println("tppPayType: " + tppPayType + " / tppId: " + tppId + " / tpAmount: " + tpAmount);
		
		model.addAttribute("tppId", tppId);
		model.addAttribute("strUserId", strUserId);
		
		model.addAttribute("tppPayType", tppPayType);
		model.addAttribute("tpAmount", tpAmount);
		
		return strView;
	}
}
