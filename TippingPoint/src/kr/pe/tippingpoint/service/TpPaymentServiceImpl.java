package kr.pe.tippingpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.pe.tippingpoint.dao.TPProjectFundingListDaoImpl;
import kr.pe.tippingpoint.dao.TpAccountPaymentDaoImpl;
import kr.pe.tippingpoint.dao.TpCardPaymentDaoImpl;
import kr.pe.tippingpoint.vo.TPProjectFundingList;
import kr.pe.tippingpoint.vo.TpAccountPayment;
import kr.pe.tippingpoint.vo.TpCardPayment;

@Service
public class TpPaymentServiceImpl implements TpPaymentService {
	
	@Autowired
	private TPProjectFundingListDaoImpl tPProjectFundingListDao;	
	@Autowired
	private TpCardPaymentDaoImpl tpCardPaymentDao;
	@Autowired
	private TpAccountPaymentDaoImpl tpAccountPaymentDao;

	@Override
	@Transactional(rollbackFor={Exception.class})
	public void insertCardPaymentAndProjectFundingList(TPProjectFundingList tpProjectFundingList,
			TpCardPayment tpCardPayment, String tpFid, String tpPid, String tppPayType, String tppPayState) {
		
		tpCardPaymentDao.insertTpCardPayment(tpCardPayment);
		
		// 프로젝트 ID세팅
		tpProjectFundingList.setTpPid(tpPid);
		
		// 일반회원ID 세팅
		tpProjectFundingList.setTpFid(tpFid);
		
		// 테이블 TPPROJECTFUNDINGLIST.TPCID에 값을 넣기위해 TPCARDPAYMENT.TPCID의 값(시퀀스에서 생성된 값이 VO에 들어가있음)을 세팅함.
		tpProjectFundingList.setTpCid(tpCardPayment.getTpCid());
		
		// 결제타입
		tpProjectFundingList.setTppPayType(tppPayType);
		// 결제상태
		tpProjectFundingList.setTppPayState(tppPayState);
		
		// convert 'java.util.date' to 'java.sql.date' ㅎㅎ		
		java.util.Date utilDate = new java.util.Date();
//	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());		
	    		
		tpProjectFundingList.setTppPayDateTime(new java.sql.Date(utilDate.getTime()));
		
		// 테이블 TPPROJECTFUNDINGLIST에 레코드 추가
		tPProjectFundingListDao.insertTPProjectFundingList(tpProjectFundingList);
		
	}

	@Override
	public void insertAccountPaymentAndProjectFundingList(TPProjectFundingList tpProjectFundingList, TpAccountPayment tpAccountPayment) {
		

		// 현금 계좌이체 DB저장		
		tpAccountPaymentDao.insertAccountPayment(tpAccountPayment);
		
		tpProjectFundingList.setTpAid(tpAccountPayment.getTpAid());
		tpProjectFundingList.setTppPayType("p"); // 카드(c) or 현금(p)
		tpProjectFundingList.setTppPayState("p"); // 결제상태 - 현금입금요청(p)
		
		java.util.Date utilDate = new java.util.Date();
//	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		tpProjectFundingList.setTppPayDateTime(new java.sql.Date(utilDate.getTime()));
		
		tPProjectFundingListDao.insertTPProjectFundingList(tpProjectFundingList);
	}

}
