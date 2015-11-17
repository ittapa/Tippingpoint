package kr.pe.tippingpoint.service;

import java.util.List;

import kr.pe.tippingpoint.vo.TpProject;

public interface TpProjectService {

	public List<TpProject> allListTpProject(int pageNo);
	
	public TpProject findTpProjectById(String tppId);
	
	public List<TpProject> findToProjectByCategory(String tppCategory);
	
	public void registerTpProject(TpProject tpproject);
	
}
