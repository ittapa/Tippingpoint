package kr.pe.tippingpoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.pe.tippingpoint.dao.TpProjectDao;
import kr.pe.tippingpoint.vo.TpProject;

@Service
public class TpProjectServiceImpl implements TpProjectService {

	@Autowired
	private TpProjectDao dao;
	
	
	@Override
	public List<TpProject> allListTpProject(int pageNo) {

		return null;
	}

	@Override
	public TpProject findTpProjectById(String tppId) {
		return null;
	}

	@Override
	public List<TpProject> findToProjectByCategory(String tppCategory) {
		return null;
	}

	@Override
	public void registerTpProject(TpProject tpvo) {
		dao.insertTpProject(tpvo);
	}

	
	
}
