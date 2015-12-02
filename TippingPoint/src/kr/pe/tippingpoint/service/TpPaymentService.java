package kr.pe.tippingpoint.service;

import kr.pe.tippingpoint.vo.TPProjectFundingList;
import kr.pe.tippingpoint.vo.TpCardPayment;

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
	public void insertCardPaymentAndProjectFundingList(TPProjectFundingList tpProjectFundingList, TpCardPayment tpCardPayment, String tpFid, String tppId, String tppPayType, String tppPayState);
}
