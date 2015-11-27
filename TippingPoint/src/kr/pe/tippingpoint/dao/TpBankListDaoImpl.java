package kr.pe.tippingpoint.dao;

import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.pe.tippingpoint.vo.TpBankList;


@Repository
public class TpBankListDaoImpl implements TpBankListDao{

	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public List<TpBankList> allTpBankList() {
		
		return session.selectList("tpBankListMapper.selectAllBankList");
	}
	
}
