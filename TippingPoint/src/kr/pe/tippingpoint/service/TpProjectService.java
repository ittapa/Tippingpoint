package kr.pe.tippingpoint.service;

import java.util.List;
import java.util.Map;

import kr.pe.tippingpoint.vo.TpProject;
import kr.pe.tippingpoint.vo.TpProjectCategory;

public interface TpProjectService {

	Map allListTpProject(int pageNo);
	
	TpProject findTpProjectById(String tppId);
	
	Map findTpProjectAndTpfunderById(String tppId);
	
	
	List<TpProject> findToProjectByCategory(String tppCategory);
	
	void registerTpProject(TpProject tpproject);
	
	Map<String, Object> serchTpProjectByKeyWord(String keyWord);
	
	Map findTpProjectByWriter(String writer);
	
	List<TpProjectCategory> tpProjectCategoryList();
	
	
	////////////////////////////첫번째 수정 //////////////////////////
	Map selectCategoryProject(int pageNo, String tppCategory);
	
	void updateTpProject(TpProject tpproject);
}
