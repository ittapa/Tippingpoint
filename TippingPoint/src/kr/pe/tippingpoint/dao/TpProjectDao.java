package kr.pe.tippingpoint.dao;

import java.util.List;


import kr.pe.tippingpoint.vo.TpProject;

public interface TpProjectDao {

	public List<TpProject> selectAllTpProject(int pageNo);
	
	public List<TpProject> selectOXEZCountProject(int pageNo);//프로젝트 전체보기 ('O,X,E')인것만
	
	public List<TpProject> selectATpProject(int pageNo);//프로젝트 전체보기 ('x')인것만

	public int selectCountProject();
	
	public int selectOEXZCountProject();

	public int selectACountProject();
	
	
	public TpProject selectTpProjectById(String tppId);
	
	public List<TpProject> selectByCategory(String tppCategory);
	
	public int insertTpProject(TpProject tpproject);
	
	public int deleteById(String tppId);
	
	public int updateTpProjectById(TpProject tpproject);
	
	public void adminUpById(TpProject adminProject);
	
	public List<TpProject> serchTpProjectByKeyWord(String keyWord);
	
	public List<TpProject> selectTpProjectByWriter(String writer);
	
	
	////////////////////////////첫번째 수정 //////////////////////////
	public List<TpProject> selectCategoryProjectDao(int pageNo, String tppCategory);//프로젝트 전체보기 ('o')인것만
	
	public int selectOAndCTCountProject(String tppCategory);
	
	

	public List<TpProject> adminCategoryProjectDao(int pageNo, String check);//프로젝트전체 보기

	public int adminCheckCountProject(String check);
	
	
}
