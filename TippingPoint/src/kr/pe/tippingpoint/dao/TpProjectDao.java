package kr.pe.tippingpoint.dao;

import java.util.List;

import kr.pe.tippingpoint.vo.TpProject;

public interface TpProjectDao {

	public List<TpProject> selectAllTpProject(int pageNo);
	
	public int selectCountProject();
	
	public TpProject selectTpProjectById(String tppId);
	
	public List<TpProject> selectByCategory(String tppCategory);
	
	public int insertTpProject(TpProject tpproject);
	
	public int deleteById(String tppId);
	
	public int updateById(TpProject tpproject);
	
	public void adminUpById(TpProject adminProject);
	
	public List<TpProject> serchTpProjectByKeyWord(String keyWord);
	
	public List<TpProject> selectTpProjectByWriter(String writer);
	
}
