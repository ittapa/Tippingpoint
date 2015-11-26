package kr.pe.tippingpoint.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.pe.tippingpoint.service.TpFunderAccountAccessServiceImpl;
import kr.pe.tippingpoint.vo.TpFunder;

// 카드결제 후 사용
import lgdacom.XPayClient.XPayClient;

/**
 * 결제 컨트롤러
 * @author Timothy 2015-11-26
 *
 */
@Controller
//@RequestMapping("/pay/")
public class tpPaymentController {
	
	@Autowired
	private TpFunderAccountAccessServiceImpl TpFunderAccService;

	/**
	 * 카드 / 현금 결제 요청 페이지 핸들러
	 * @param: String tppPayType - 결제 타입("p": 현금 계좌이체 / "c": 카드) 
	 * @param String tppTitle - 프로젝트 제목 
	 * @param int tpAmount - 결제 금액
	 * @param session
	 * @param model
	 * @return URL: 계좌이체 요청 페이지 or 카드 결제 요청 페이지
	 */
	@RequestMapping(value={"payCardRequest.tp", "payAccountRequest.tp"})
	public String payRequest(@RequestParam String tppPayType, @RequestParam String tppTitle, @RequestParam int tpAmount, HttpSession session, ModelMap model){
		// TODO: 세션 처리되는 페이지 통합시 테스트 코드 삭제		
		session.setAttribute("userLoginInfo", "1");

		
		String tppId = (String)session.getAttribute("userLoginInfo");
				
		// 세션 사용자ID 체크
		// FIXME: 인터셉터로 세션 ID 존재 유무 체크로 수정하기 & 이전에 보고 있던 페이지로 되돌아가도록 처리하기
		if(tppId.trim().length() < 1){
			return "redirct:/tpProjectBoard.tp";
		}
		
		// user정보 가져오기
		TpFunder tpFunder = TpFunderAccService.findTpFunderById(tppId);
		
		
		// Start: 주문 번호 생성
		SimpleDateFormat sf = new SimpleDateFormat("MMddHHmmss");
		Date current = new Date();
		String strCurrent = sf.format(current);

		String strUuid = UUID.randomUUID().toString();
		strUuid = strUuid.replace("-", "") ;


		String strOrderUId = tppId + "_" + strCurrent + strUuid;
		// End: 주문 번호 생성
		
		// 타임스탬프
		sf = new SimpleDateFormat("yyyyMMddHHmmss");
		strCurrent = sf.format(current);
		
		
		
		
//		String strView = "/WEB-INF/view/body/tpPayment/";
		String strView = "tpPayment/";
		if(tppPayType.equals("p")){ // 현금 계좌이체
			strView += "payAccountRequest.tiles";
		} else { // card
			strView += "payCardRequest.tiles";
		}
		
		// TODO: 결제완료 페이지에서 세션 삭제
		// 세션을 통해 주문 유요성 체크
		session.setAttribute("strOrderUId", strOrderUId); // 주문번호
		session.setAttribute("tppId", tppId); // 프로젝트 ID(상품ID)
		session.setAttribute("tpAmount", tpAmount); // 주문 금액
		
		
		
		
		model.addAttribute("tppId", tppId); // 프로젝트 ID
		model.addAttribute("tppTitle", tppTitle); // 프로젝트 제목
		
		model.addAttribute("tppPayType", tppPayType); // 결제 타입
		model.addAttribute("tpAmount", tpAmount); //  결제 금액
		model.addAttribute("strOrderUId", strOrderUId); // 주문번호
		model.addAttribute("tpfEmail", tpFunder.getTpfEmail()); // 주문자 email
		model.addAttribute("LGD_TIMESTAMP", strCurrent); // 주문 시각
		
		// TODO: 주문내역 Console log - 테스트 후 삭제
		System.out.println("tppId: " + tppId + " + tppTitle: " + tppTitle + " + tppPayType: " + tppPayType 
				+ " / tppId: " + tppId + " / tpAmount: " + tpAmount + " / strOrderUId: " + strOrderUId 
				+ " / tpFunder.getTpfEmail(): " + tpFunder.getTpfEmail() + " / strCurrent: " + strCurrent + " / strView: " + strView);
		
		return strView;
	}
	
	// 결제후 처리(DB처리 포함)
	@RequestMapping("tpPayCardRet.tp")
	public String payCardRet(HttpRequest request){
		
		
		return "";
	}
	
	// 결제 실패
	@RequestMapping("tpPayCardFailed.tp")
	public String payCardFailed(){
		return "";
	}
}
