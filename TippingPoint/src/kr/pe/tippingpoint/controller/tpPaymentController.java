package kr.pe.tippingpoint.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.pe.tippingpoint.service.TpAccountPaymentService;
import kr.pe.tippingpoint.service.TpFunderAccountAccessService;
import kr.pe.tippingpoint.service.TpPaymentService;
import kr.pe.tippingpoint.service.TpProjectService;
import kr.pe.tippingpoint.vo.TPProjectFundingList;
import kr.pe.tippingpoint.vo.TpAccountPayment;
import kr.pe.tippingpoint.vo.TpCardPayment;
import kr.pe.tippingpoint.vo.TpFunder;
import kr.pe.tippingpoint.vo.TpProject;
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
	private TpFunderAccountAccessService TpFunderAccService;
	
	@Autowired
	private TpProjectService tpProjectService;
	@Autowired
	TpPaymentService tpPaymentService;
	@Autowired
	TpAccountPaymentService tpAccountPaymentService; 

	/**
	 * 카드 / 현금 결제 요청 페이지 핸들러
	 * @param: String tppPayType - 결제 타입("p": 현금 계좌이체 / "c": 카드) 
	 * @param String tppTitle - 프로젝트 제목 
	 * @param int tpAmount - 결제 금액
	 * @param session
	 * @param model
	 * @return URL: 계좌이체 요청 페이지 or 카드 결제 요청 페이지
	 */
//	@RequestMapping(value={"payCardRequest.tp", "payAccountRequest.tp"})
	// payreq_crossflatform
	@RequestMapping("payCardRequest.tp")
	public String payRequest(@RequestParam String tppPayType, @RequestParam String tppId, @RequestParam String tppTitle, @RequestParam int tpAmount, HttpSession session, ModelMap model){
		
		// 결제가 가능한 프로젝트인지 판단
//		tpProjectService.
		

		// TODO: 세션 처리되는 페이지 통합시 테스트 코드 삭제		
//		session.setAttribute("userLoginInfo", "asdfasdf");
		
		// FIXME: 회원이 없는 경우 예외처리
		String tpfId = (String)session.getAttribute("userLoginInfo");
		
		// 세션 사용자ID 체크
		// FIXME: 인터셉터로 세션 ID 존재 유무 체크로 수정하기 & 이전에 보고 있던 페이지로 되돌아가도록 처리하기
		if(tpfId.trim().length() < 1){
			return "redirct:/tpProjectBoard.tp";
		}
		
		// user정보 가져오기
		TpFunder tpFunder = TpFunderAccService.findTpFunderById(tpfId);
		
		
		// Start: 주문 번호 생성
		SimpleDateFormat sf = new SimpleDateFormat("MMddHHmmss");
		Date current = new Date();
		String strCurrent = sf.format(current);

		String strUuid = UUID.randomUUID().toString();
		strUuid = strUuid.replace("-", "") ;


		String strOrderUId = tpfId + "_" + strCurrent + strUuid;
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
//		session.setAttribute("tpfId", tpfId); // 사용자 ID
		session.setAttribute("tppId", tppId); // 프로젝트 ID(상품ID)
		session.setAttribute("tpAmount", tpAmount); // 주문 금액
		
		
		
		
		model.addAttribute("tppId", tppId); // 프로젝트 ID
		model.addAttribute("tppTitle", tppTitle); // 프로젝트 제목
		
		model.addAttribute("tppPayType", tppPayType); // 결제 타입
		model.addAttribute("tpAmount", tpAmount); //  결제 금액
		model.addAttribute("strOrderUId", strOrderUId); // 주문번호
		
		model.addAttribute("tpfEmail", tpFunder.getTpfEmail()); // 주문자 email	
		
		model.addAttribute("LGD_TIMESTAMP", strCurrent); // 주문 시각
		
		/*
		// TODO: 주문내역 Console log - 테스트 후 삭제
		System.out.println("tppId: " + tppId + " + tppTitle: " + tppTitle + " + tppPayType: " + tppPayType 
				+ " / tppId: " + tppId + " / tpAmount: " + tpAmount + " / strOrderUId: " + strOrderUId 
				+ " / tpFunder.getTpfEmail(): " + tpFunder.getTpfEmail() + " / strCurrent: " + strCurrent + " / strView: " + strView);
		*/
		return strView;
	}
	

	// 결제후 처리(DB처리 포함)
	@RequestMapping("tpPayPgReturn.tp")
//	public String payCardRet(@RequestParam HttpServletRequest request, HttpSession session, ModelMap model){
	public String payCardRet(TpProject tpproject, TPProjectFundingList tpProjectFundingList, TpCardPayment tpCardPayment, HttpServletRequest request, HttpSession session, ModelMap model){

		// 아래 항목들 DI로 옮기지 마세요.
	    String CST_PLATFORM                 = request.getParameter("CST_PLATFORM");
	    String CST_MID                      = request.getParameter("CST_MID");
	    String LGD_MID                      = ("test".equals(CST_PLATFORM.trim())?"t":"")+CST_MID;
	    String LGD_PAYKEY                   = request.getParameter("LGD_PAYKEY");

		// String configPath = "C:/lgdacom"; //LG유플러스에서 제공한
		// 환경파일("/conf/lgdacom.conf,/conf/mall.conf") 위치 지정.
		ServletContext servletContext = request.getServletContext();
//		String configPath = servletContext.getInitParameter("LGUPlusPgConfPath");
		String configPath = "/usr/local/tomcat8/webapps/TippingPoint/lgdacom";

		// TODO: 삭제
		System.out.println("결제모듈 경로: " + configPath);

		// 해당 API를 사용하기 위해 WEB-INF/lib/XPayClient.jar 를 Classpath 로 등록하셔야 합니다.
		XPayClient xpay = new XPayClient();
		boolean isInitOK = xpay.Init(configPath, CST_PLATFORM);
		

		String errMsg = "";

		if (!isInitOK) {

			// API 초기화 실패 화면처리
			errMsg += "결제요청을 초기화 하는데 실패하였습니다.<br>";
			errMsg += "LG유플러스에서 제공한 환경파일이 정상적으로 설치 되었는지 확인하시기 바랍니다.<br>";
			// errMsg += "mall.conf에는 Mert ID = Mert Key 가 반드시 등록되어 있어야 합니다.<br><br>";
			errMsg += "문의전화 LG유플러스 1544-7772<br>";

			System.out.println("API 초기화 실패!");
			// 결제모듈 에러 페이지로 전환!
			model.addAttribute("errMsg", errMsg);
			return "tpPayment/errMsg.tiles";

		} else {
			try {
				/*
				 *************************************************
				 * 1.최종결제 요청(수정하지 마세요) - END
				 *************************************************
				 */
				xpay.Init_TX(LGD_MID);
				xpay.Set("LGD_TXNAME", "PaymentByKey");
				xpay.Set("LGD_PAYKEY", LGD_PAYKEY);

				// 세션을 통한 결제금액 체크
				String DB_AMOUNT = String.valueOf(session.getAttribute("tpAmount")); // 반드시 위변조가 불가능한 곳(DB나 세션)에서 금액을 가져오십시요.
				
				xpay.Set("LGD_AMOUNTCHECKYN", "Y");
				xpay.Set("LGD_AMOUNT", DB_AMOUNT);

			} catch (Exception e) {
				errMsg += "LG유플러스 제공 API를 사용할 수 없습니다. 환경파일 설정을 확인해 주시기 바랍니다. <br/>";
				errMsg += "에러 메시지: " + e.getMessage();

				System.out.println("LG유플러스 제공 API를 사용할 수 없습니다!");
				// 결제모듈 에러 페이지로 전환!

				model.addAttribute("errMsg", errMsg);
				return "tpPayment/errMsg.tiles";

			}
		}

		/*
		 * 2. 최종결제 요청 결과처리
		 *
		 * 최종 결제요청 결과 리턴 파라미터는 연동메뉴얼을 참고하시기 바랍니다.
		 */
		if (xpay.TX()) {
			// 1)결제결과 화면처리(성공,실패 결과 처리를 하시기 바랍니다.)
			/*
			 System.out.println( "결제요청이 완료되었습니다.  <br>");
			 System.out.println("TX 결제요청 Response_code = " + xpay.m_szResCode + "<br>");
			 System.out.println( "TX 결제요청 Response_msg = " + xpay.m_szResMsg + "<p>");
			 
			 System.out.println("거래번호 : " + xpay.Response("LGD_TID",0) +"<br>");
			 System.out.println("상점아이디 : " + xpay.Response("LGD_MID",0) + "<br>");
			 System.out.println("상점주문번호 : " + xpay.Response("LGD_OID",0) + "<br>");
			 System.out.println("결제금액 : " + xpay.Response("LGD_AMOUNT",0) + "<br>");
			 System.out.println("결과코드 : " + xpay.Response("LGD_RESPCODE",0) + "<br>");
			 System.out.println("결과메세지 : " + xpay.Response("LGD_RESPMSG",0) + "<p>");
			 */
			 
			/*
			 for (int i = 0; i < xpay.ResponseNameCount(); i++) {
			 System.out.println(xpay.ResponseName(i) + " = ");
			 for (int j = 0; j < xpay.ResponseCount(); j++) {
				 System.out.println("\t" + xpay.Response(xpay.ResponseName(i), j) + "<br>");
				 }
			 }
			 */

			if ("0000".equals(xpay.m_szResCode)) {
				// 최종결제요청 결과 성공 DB처리
				// System.out.println("최종결제요청 결과 성공 DB처리하시기 바랍니다.<br>");
				
				model.addAttribute("m_szResCode", xpay.m_szResCode);
				model.addAttribute("Response_msg", xpay.m_szResMsg);
				model.addAttribute("LGD_TID", xpay.Response("LGD_TID",0));
				model.addAttribute("LGD_MID", xpay.Response("LGD_MID",0));
				model.addAttribute("LGD_OID", xpay.Response("LGD_OID",0));
				model.addAttribute("LGD_AMOUNT", xpay.Response("LGD_AMOUNT",0));
				model.addAttribute("LGD_RESPCODE", xpay.Response("LGD_RESPCODE",0));
				model.addAttribute("LGD_RESPMSG", xpay.Response("LGD_RESPMSG",0));
				model.addAttribute("tppId", (String)session.getAttribute("tppId"));
				
				// xpay 응답결과 -> VO담기
				tpCardPayment.setTpLgdRespcode(xpay.m_szResCode);
				tpCardPayment.setTpLgdResPMsg(xpay.m_szResMsg);
				tpCardPayment.setTpLgdOid(xpay.Response("LGD_OID",0));
				tpCardPayment.setTpLgdTid(xpay.Response("LGD_TID",0));
				tpCardPayment.setTpLgdHashData(xpay.Response("LGD_HASHDATA",0));
				tpCardPayment.setTpLgdFinanceCode(xpay.Response("LGD_FINANCECODE",0));
				tpCardPayment.setTpLgdFinanceName(xpay.Response("LGD_FINANCENAME",0));
				tpCardPayment.setTpLgdEscrowYN(xpay.Response("LGD_ESCROWYN",0));
				tpCardPayment.setTpLgdTransAmount(xpay.Response("LGD_TRANSAMOUNT",0));
				tpCardPayment.setTpLgdExchangeRate(xpay.Response("LGD_EXCHANGERATE",0));
				tpCardPayment.setTpLgdBuyer(xpay.Response("LGD_BUYER",0));
				tpCardPayment.setTpLgdBuyerPhone(xpay.Response("LGD_BUYERPHONE",0));
				tpCardPayment.setTpLgdBuyerEmail(xpay.Response("LGD_BUYEREMAIL",0));
				tpCardPayment.setTpLgdProductInfo(xpay.Response("LGD_PRODUCTINFO",0));
				tpCardPayment.setTpLgdCardNum(xpay.Response("LGD_CARDNUM",0));
				tpCardPayment.setTpLgdCardInstallMonth(xpay.Response("LGD_CARDINSTALLMONTH",0));
				tpCardPayment.setTpLgdCardNoIntYN(Integer.valueOf(xpay.Response("LGD_CARDNOINTYN",0)));
				tpCardPayment.setTpLgdFinanceAuthNum(xpay.Response("LGD_FINANCEAUTHNUM",0));
				tpCardPayment.setTpCAmount(Integer.valueOf(xpay.Response("LGD_AMOUNT",0)));
								
				
				// Service단 처리
				tpPaymentService.insertCardPaymentAndProjectFundingList(tpProjectFundingList, tpCardPayment
						, (String)session.getAttribute("userLoginInfo"), (String)session.getAttribute("tppId"), "c", "o");
				
				
				tpproject.setTppId((String)session.getAttribute("tppId")); // 프로젝트 ID(상품ID)
				tpproject.setTppTotalAmount(Integer.valueOf(xpay.Response("LGD_AMOUNT",0)));// 주문(후원) 금액
								
				tpProjectService.addFunderNumAndTotalAmount(tpproject);
						

				// 최종결제요청 결과 성공 DB처리 실패시 Rollback 처리
				boolean isDBOK = true; // DB처리 실패시 false로 변경해 주세요.
				if (!isDBOK) {
					xpay.Rollback("상점 DB처리 실패로 인하여 Rollback 처리 [TID:" + xpay.Response("LGD_TID", 0) + ",MID:"
							+ xpay.Response("LGD_MID", 0) + ",OID:" + xpay.Response("LGD_OID", 0) + "]");

					System.out.println("TX Rollback Response_code = " + xpay.Response("LGD_RESPCODE", 0) + "<br>");
					System.out.println("TX Rollback Response_msg = " + xpay.Response("LGD_RESPMSG", 0) + "<p>");

					if ("0000".equals(xpay.m_szResCode)) {
						errMsg += "자동취소가 정상적으로 완료 되었습니다.<br>";
						
					} else {
						errMsg += "자동취소가 정상적으로 처리되지 않았습니다.<br>";
					}
					
					model.addAttribute("errMsg", errMsg);
					return "tpPayment/errMsg.tiles";
				}

			} else {
				// 최종결제요청 결과 실패 DB처리
				// XXX: 결제가 안되었으므로 rollback할 것이 없다.
				
				errMsg += "최종결제요청 결과 실패";
				/*
				errMsg += " /m_szResCode: ";
				errMsg += xpay.m_szResCode;
				errMsg += " /m_szResMsg: ";
				errMsg += xpay.Response("m_szResMsg",0);
				errMsg += " /LGD_TID: ";
				errMsg += xpay.Response("LGD_TID",0);
				errMsg += " /LGD_MID: ";
				errMsg += xpay.Response("LGD_MID",0);
				errMsg += " /LGD_OID: ";
				errMsg += xpay.Response("LGD_OID",0);
				errMsg += " /LGD_AMOUNT: ";
				errMsg += xpay.Response("LGD_AMOUNT",0);
				errMsg += " /LGD_RESPCODE: ";
				errMsg += xpay.Response("LGD_RESPCODE",0);
				errMsg += " /LGD_RESPMSG: ";
				errMsg += xpay.Response("LGD_RESPMSG",0);
				*/
				
				model.addAttribute("errMsg", errMsg);
				return "tpPayment/errMsg.tiles";
				
			}
		} else {
/*
			// 2)API 요청실패 화면처리
			System.out.println("결제요청이 실패하였습니다.  <br>");
			System.out.println("TX 결제요청 Response_code = " + xpay.m_szResCode + "<br>");
			System.out.println("TX 결제요청 Response_msg = " + xpay.m_szResMsg + "<p>");
*/
			// 최종결제요청 결과 실패 DB처리
			//System.out.println("최종결제요청 결과 실패 DB처리하시기 바랍니다.<br>");
			// XXX: 결제가 안되었으므로 rollback할 것이 없다.
			
			// 결제모듈 에러 페이지로 전환!
			errMsg += "결제요청이 실패하였습니다.";
			errMsg += "결제 모듈 응답 메시지: " + xpay.m_szResMsg;
			
			model.addAttribute("errMsg", errMsg);
			return "tpPayment/errMsg.tiles";
			
		}

		// TODO: 세션 삭제

		return "tpPayment/payCardSuccess.tiles";
	}
	
	/**
	 * 현금 계좌이체 요청 내용 표시
	 * @param tppTitle
	 * @param tpAmount
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("payAccountRequest.tp")
	public String payAccountRequest(@RequestParam String tppId,@RequestParam String tppTitle, @RequestParam int tpAmount, HttpSession session, ModelMap model){
		
		model.put("tppTitle", tppTitle);
		model.put("tppId", tppId);
		model.put("tpAmount", tpAmount);
		
		return "tpPayment/payAccountRequest.tiles";
	}
	
	/**
	 * 현금 계좌이체 요청 처리
	 * @return
	 */
	@RequestMapping("payAccountRequestSave.tp")
	public String payAccountProcess(@ModelAttribute TpAccountPayment tpAccountPayment, @RequestParam String tppId, TpProject tpproject, TPProjectFundingList tpProjectFundingList, HttpSession session){
		
		
		// 현금 계좌이체 DB저장하기 위해 VO일부 세팅
		tpProjectFundingList.setTpPid(tppId);
		tpProjectFundingList.setTpFid((String)session.getAttribute("userLoginInfo"));
		
		tpPaymentService.insertAccountPaymentAndProjectFundingList(tpProjectFundingList, tpAccountPayment);
		
		
		return "tpPayment/payAccountResult.tiles";
	}
}
