package kr.pe.tippingpoint.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.pe.tippingpoint.vo.TpProjectCategory;

@Repository
public class TpProjectCategoryDaoImpl implements TpProjectCategoryDao{

	@Autowired
	private SqlSessionTemplate session;//no-arg생성자로 객체생성후 instance변수에 바로 주입

	
	public TpProjectCategoryDaoImpl() {
		super();
	}


	@Override
	public List<TpProjectCategory> selectTpProjectCategory() {
		return session.selectList("tpProjectCategoryMapper.selectAllTpProjectCategory");
	}

	//카테고리 삭제
	@Override
	public void deleteTpProjectCategoryByCategory(String tppCategoryName) {
		session.insert("tpProjectCategoryMapper.deletTpProjectCategoryByCategory", tppCategoryName);
	}

	//카테고리 추가
	@Override
	public void insertTpProjectCategoryByCategory(String tppCategory, String tppCategoryName) {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("tppCategory", tppCategory);
		map.put("tppCategoryName", tppCategoryName);
		System.out.println(map.get("tppCategoryName"));
		session.insert("tpProjectCategoryMapper.insertTpProjectCategoryByCategory", map);
	}


	@Override
	public void updateTpProjectCategoryByCategory(TpProjectCategory category, String updateCategory) {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("tppCategory", category.getTppCategory());
		map.put("tppCategoryName", category.getTppCategoryName());
		map.put("updateCategory", updateCategory);
		session.update("tpProjectCategoryMapper.updateTpProjectCategoryByCategory",map);
	}
	
	

	
}
