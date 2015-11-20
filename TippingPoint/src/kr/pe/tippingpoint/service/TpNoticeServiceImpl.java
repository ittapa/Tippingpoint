package kr.pe.tippingpoint.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.tippingpoint.dao.TpNoticeDao;
import kr.pe.tippingpoint.util.PagingBean;
import kr.pe.tippingpoint.vo.TpNotice;
import kr.pe.tippingpoint.vo.TpProject;

@Service
public class TpNoticeServiceImpl implements TpNoticeService {

	@Autowired
	private TpNoticeDao dao;

	@Override
	public Map allListTpNotice(int pageNo) {
		HashMap map = new HashMap();
		List<TpProject> list = dao.selectAllTpNotice(pageNo);
		PagingBean pagingBean = new PagingBean(dao.selectCountTpNotice(), pageNo);
		map.put("list", list); // 목록에 뿌려질 고객들 정보
		map.put("pagingBean", pagingBean); // 페이징 처리위한 pagingBean
		return map;
	}

	@Override
	public TpNotice findTpNoticeNum(int tpNoticeNum) {
		return dao.selectTpNoticeNum(tpNoticeNum);
	}

	@Override
	public List<TpProject> findToProjectByCategory(String tppCategory) {
		return null;
	}

	@Override
	public void registerTpProject(TpProject tpproject) {

	}

}
