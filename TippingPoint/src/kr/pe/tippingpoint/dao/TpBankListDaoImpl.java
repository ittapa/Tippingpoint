package kr.pe.tippingpoint.dao;

import java.util.HashMap;
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

	@Override
	public void insertBankListByCode(String bankKr, String bankEr, String code) {
		
		HashMap map = new HashMap();
		map.put("bankKr", bankKr);
		map.put("bankEr", bankEr);
		map.put("code", code);
		
		session.insert("tpBankListMapper.insertBank",map);
		
	}

	@Override
	public void deleteBankListById(String bankKr) {

		session.delete("tpBankListMapper.deleteBank", bankKr);
		
	}

	@Override
	public void updateBankList(String updateBank, TpBankList bankList) {

		HashMap map = new HashMap();
		map.put("bankKr", bankList.getBankKr());
		map.put("bankEr", bankList.getBankEr());
		map.put("code", bankList.getCode());
		map.put("updateBank", updateBank);
		
		session.update("tpBankListMapper.updateBank", map);
		
	}
	
	
	
	
}
