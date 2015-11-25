package kr.pe.tippingpoint.dao;

import kr.pe.tippingpoint.vo.TpProposer;

public interface TpProposerDao {

	public void insertInfo(TpProposer tposer);
	
	
	//////////////////////////////////////////////수정중/////////////////////////////////////////////////
	public void addTpfQualFy(String t);
}
