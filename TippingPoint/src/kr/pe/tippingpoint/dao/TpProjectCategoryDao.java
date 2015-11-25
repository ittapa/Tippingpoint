package kr.pe.tippingpoint.dao;

import java.util.List;

import kr.pe.tippingpoint.vo.TpProjectCategory;

public interface TpProjectCategoryDao {

	public List<TpProjectCategory> selectTpProjectCategory();
	
	public int deleteTpProjectCategoryByCategory();
	
	public int insertTpProjectCategoryByCategory();
	
}
