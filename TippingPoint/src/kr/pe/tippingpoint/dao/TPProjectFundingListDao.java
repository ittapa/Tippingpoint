package kr.pe.tippingpoint.dao;

import java.sql.Date;
import java.util.List;

import kr.pe.tippingpoint.vo.TPProjectFundingList;

public interface TPProjectFundingListDao {
	/**
	 * TPProjectFundingList추가
	 * 
	 * @param listNum : int
	 * @param tpPid : String
	 * @param tpFid : String
	 * @param tpCid : int
	 * @param tpAid : int
	 * @param tppPayType : String
	 * @param tppPayState : String
	 * @param tppPayDateTime : Date
	 * @param tppPayCancelReqDateTime : Date
	 * @param tpCCid : int
	 */
	public int insertTPProjectFundingList(TPProjectFundingList tPProjectFundingList);
	
	/**
	 * 프로젝트ID로 ProjectFundingList 조회
	 * @param TpPid
	 * @return List : TPProjectFundingList
	 */
	public List<TPProjectFundingList> selectTPProjectFundingListByTpPid(String TpPid);
	

	/**
	 * Funder ID(사용자ID)로 ProjectFundingList 조회
	 * @param TpFid
	 * @return List : TPProjectFundingList
	 */
	public List<TPProjectFundingList> selectTPProjectFundingListByTpFid(String TpFid);
	
	/**
	 * 전체 ProjectFundingList 조회
	 * @return List : TPProjectFundingList
	 */
	public List<TPProjectFundingList> selectAllTPProjectFundingList();
	
	/**
	 * 현금 입금요청 ProjectFundingList 조회 - tppPayState: p
	 * @return List : TPProjectFundingList
	 */
	public List<TPProjectFundingList> selectTPProjectFundingListPayRequired();
	
	
	
	/**
	 * 결제완료 ProjectFundingList 조회 - tppPayState: o
	 * @return List : TPProjectFundingList
	 */
	public List<TPProjectFundingList> selectTPProjectFundingListComplete();
	
	/**
	 * 현금 결제완료 ProjectFundingList 조회 - tppPayState: o & tppPayType: p
	 * @return List : TPProjectFundingList
	 */
	public List<TPProjectFundingList> selectTPProjectFundingListCompleteAsPayment();
	
	/**
	 * 카드 결제완료 ProjectFundingList 조회 - tppPayState: o & tppPayType: c
	 * @return List : TPProjectFundingList
	 */
	public List<TPProjectFundingList> selectTPProjectFundingListCompleteAsCard();
	
	
	
	/**
	 * 현금 입금 취소요청 ProjectFundingList 조회 - tppPayState: r
	 * @return List : TPProjectFundingList
	 */
	public List<TPProjectFundingList> selectTPProjectFundingListPayCancelRequired();
	
	
	
	/**
	 * 현금 입금 취소완료 ProjectFundingList 조회 - tppPayState: c
	 * @return List : TPProjectFundingList
	 */
	public List<TPProjectFundingList> selectTPProjectFundingListPayCancelCompleted();
	
	
}
