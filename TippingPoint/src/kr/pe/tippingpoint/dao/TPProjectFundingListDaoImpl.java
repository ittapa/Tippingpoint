package kr.pe.tippingpoint.dao;

import java.sql.Date;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.pe.tippingpoint.vo.TPProjectFundingList;

@Repository
public class TPProjectFundingListDaoImpl implements TPProjectFundingListDao {

	@Autowired
	private SqlSessionTemplate session;
	
	public TPProjectFundingListDaoImpl() {}
	
	public TPProjectFundingListDaoImpl(SqlSessionTemplate session) {
		this.session = session;
	}


	@Override
	public int insertTPProjectFundingList(TPProjectFundingList tPProjectFundingList) {
		return session.insert("tpPaymentMapper.insertTPProjectFundingList", tPProjectFundingList);
	}

	@Override
	public List<TPProjectFundingList> selectTPProjectFundingListByTpPid(String TpPid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TPProjectFundingList> selectTPProjectFundingListByTpFid(String TpFid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TPProjectFundingList> selectAllTPProjectFundingList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TPProjectFundingList> selectTPProjectFundingListPayRequired() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TPProjectFundingList> selectTPProjectFundingListComplete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TPProjectFundingList> selectTPProjectFundingListCompleteAsPayment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TPProjectFundingList> selectTPProjectFundingListCompleteAsCard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TPProjectFundingList> selectTPProjectFundingListPayCancelRequired() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TPProjectFundingList> selectTPProjectFundingListPayCancelCompleted() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
