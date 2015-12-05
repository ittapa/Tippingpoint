package kr.pe.tippingpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.tippingpoint.dao.TpAccountPaymentDao;
import kr.pe.tippingpoint.vo.TpAccountPayment;

@Service
public class TpAccountPaymentServiceImpl implements TpAccountPaymentService {
	
	@Autowired
	private TpAccountPaymentDao tpAccountPaymentDao;

	@Override
	public void insertAccountPayment(TpAccountPayment tpAccountPayment) {
		tpAccountPaymentDao.insertAccountPayment(tpAccountPayment);
	}

}
