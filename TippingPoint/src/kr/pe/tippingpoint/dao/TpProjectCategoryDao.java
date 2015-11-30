package kr.pe.tippingpoint.dao;

import java.util.List;

import kr.pe.tippingpoint.vo.TpProjectCategory;

public interface TpProjectCategoryDao {

	public List<TpProjectCategory> selectTpProjectCategory();
	
	public void deleteTpProjectCategoryByCategory(String tppCategoryName);

	public void insertTpProjectCategoryByCategory(String tppCategory, String tppCategoryName);
	
	public void updateTpProjectCategoryByCategory(TpProjectCategory category, String updateCategory);
		
}
