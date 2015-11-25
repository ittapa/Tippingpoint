package kr.pe.tippingpoint.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.pe.tippingpoint.vo.TpProposer;



@Repository
public class TpProposerDaoImpl implements TpProposerDao{
	

	@Autowired
	private SqlSessionTemplate session;

	@Override
	public void insertInfo(TpProposer tposer) {
		session.insert("tpProposerMapper.insertTpProposer", tposer);
	}

	
	//////////////////////////////////////////////수정중/////////////////////////////////////////////////
	@Override
	public void addTpfQualFy(String t) {
		session.update("tpProposerMapper.updateTpfQualFy", t);	
	}
	
	

}
