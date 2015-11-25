package kr.pe.tippingpoint.service;

import java.util.List;
import java.util.Map;

import kr.pe.tippingpoint.vo.TpProject;
import kr.pe.tippingpoint.vo.TpProjectCategory;

public interface TpProjectService {

	public Map allListTpProject(int pageNo);
	
	public TpProject findTpProjectById(String tppId);
	
	public List<TpProject> findToProjectByCategory(String tppCategory);
	
	public void registerTpProject(TpProject tpproject);
	
	public Map<String, Object> serchTpProjectByKeyWord(String keyWord);
	
	public Map findTpProjectByWriter(String writer);
	
	public List<TpProjectCategory> tpProjectCategoryList();
	
	
	////////////////////////////첫번째 수정 //////////////////////////
	public Map selectCategoryProject(int pageNo, String tppCategory);
}
