package kr.pe.tippingpoint.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.pe.tippingpoint.vo.TpAccountPayment;

@Repository
public class TpAccountPaymentDaoImpl implements TpAccountPaymentDao {
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public int insertAccountPayment(TpAccountPayment tpAccountPayment) {		
		return session.insert("tpAccountPaymentMapper.insertAccountPayment", tpAccountPayment);
	}

}
