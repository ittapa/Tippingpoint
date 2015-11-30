package kr.pe.tippingpoint.dao;

import java.util.List;

import kr.pe.tippingpoint.vo.TpBankList;

public interface TpBankListDao {

	List<TpBankList> allTpBankList ();
	
	void insertBankListByCode (String bankKr, String bankEr, String code);
	
	void deleteBankListById(String bankKr);
	
	void updateBankList(String updateBank, TpBankList bankList);
	
}
