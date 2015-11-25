package kr.pe.tippingpoint.dao;

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

	
	//todo
	@Override
	public int deleteTpProjectCategoryByCategory() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertTpProjectCategoryByCategory() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
