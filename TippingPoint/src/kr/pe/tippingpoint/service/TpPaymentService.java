package kr.pe.tippingpoint.service;

import kr.pe.tippingpoint.vo.TPProjectFundingList;
import kr.pe.tippingpoint.vo.TpAccountPayment;
import kr.pe.tippingpoint.vo.TpCardPayment;

/**
 * 결제관련 DB처리
 * @author Timothy 2015-12
 *
 */
public interface TpPaymentService {
	/**
	 * 카드 결제 완료 시, TPPROJECTFUNDINGLIST 및 TPACCOUNTPAYMENT 테이블에 추가
	 * @param tpProjectFundingList : TPProjectFundingList
	 * @param tpCardPayment : TpCardPayment
	 * @param tpFid : String
	 * @param tppId : String
	 * @param tppPayType : String
	 * @param tppPayState : String
	 */
	
	/**
	 * 카드결제 DB 처리 
	 * @param tpProjectFundingList
	 * @param tpCardPayment
	 * @param tpFid
	 * @param tppId
	 * @param tppPayType
	 * @param tppPayState
	 */
	public void insertCardPaymentAndProjectFundingList(TPProjectFundingList tpProjectFundingList, TpCardPayment tpCardPayment, String tpFid, String tppId, String tppPayType, String tppPayState);
	
	/**
	 * 현금 결제 DB 처리
	 * @param tpProjectFundingList
	 * @param tpAccountPayment
	 */
	public void insertAccountPaymentAndProjectFundingList(TPProjectFundingList tpProjectFundingList, TpAccountPayment tpAccountPayment);
}
