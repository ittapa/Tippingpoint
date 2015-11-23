package kr.pe.tippingpoint.service;

import java.util.List;
import java.util.Map;

import kr.pe.tippingpoint.vo.TpNotice;
import kr.pe.tippingpoint.vo.TpProject;

public interface TpNoticeService {

	public Map allListTpNotice(int pageNo);
	
	public TpNotice findTpNoticeNum(int tpNoticeNum);
	
	public List<TpProject> findToProjectByCategory(String tppCategory);
	
	public void registerTpProject(TpProject tpproject);
	

}
