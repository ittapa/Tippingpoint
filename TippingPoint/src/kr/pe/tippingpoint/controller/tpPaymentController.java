package kr.pe.tippingpoint.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pay/")
public class tpPaymentController {

	@RequestMapping("payRequest.do")
	public String payRequest(@RequestParam String tppPayType, @RequestParam String tppId, @RequestParam int tpAmount, HttpServletRequest request){
		return "";
	}
}
