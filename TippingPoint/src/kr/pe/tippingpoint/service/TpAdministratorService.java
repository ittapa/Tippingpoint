package kr.pe.tippingpoint.service;

import java.util.Map;

import kr.pe.tippingpoint.vo.TpBankList;
import kr.pe.tippingpoint.vo.TpProject;
import kr.pe.tippingpoint.vo.TpProjectCategory;

public interface TpAdministratorService {

	public Map adminAllListTpProject(int pageNo);

	public TpProject adminFindTpProjectById(String tppId);

	public void adminProjectUp(TpProject adminProject);

	//////////////////////////// 첫번째 수정 //////////////////////////
	public Map adminCategoryProject(int pageNo, String check);

	///////////////////////////////////// 카테고리 관련 페이지	/////////////////////////////////////
	public void addTpCategory(String tppCategory, String tppCategoryName);

	public void deleteTpCategory(String tppCategoryName);

	public void updateTpCategory(TpProjectCategory category, String updateCategory);
	
	public void addBank(String bankKr, String bankEr, String code);

	public void deleteBank(String bankKr);

	public void updateBank(String updateBank, TpBankList bankList);

}
