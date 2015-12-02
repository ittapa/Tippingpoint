package kr.pe.tippingpoint.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.pe.tippingpoint.vo.TpCardPayment;

@Repository("tpCardPayment")
public class TpCardPaymentDaoImpl implements TpCardPaymentDao {

	@Autowired
	private SqlSessionTemplate session;
	
	public TpCardPaymentDaoImpl() {	}
	
	
	public TpCardPaymentDaoImpl(SqlSessionTemplate session) {
		this.session = session;
	}


	@Override
	public int insertTpCardPayment(TpCardPayment tpCardPayment) {		
		return session.insert("tpCardPaymentMapper.insertTpCardPayment", tpCardPayment);
	}

}
