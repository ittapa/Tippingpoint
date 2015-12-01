package kr.pe.tippingpoint.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.tippingpoint.dao.TpNoticeDao;
import kr.pe.tippingpoint.exception.DuplicatedIdException;
import kr.pe.tippingpoint.util.TpNoticeBoardPagingBean;
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
		TpNoticeBoardPagingBean pagingBean = new TpNoticeBoardPagingBean(dao.selectCountTpNotice(), pageNo);
		map.put("list", list);
		map.put("pagingBean", pagingBean);
		return map;
	}

	@Override
	public TpNotice findTpNoticeNum(int tpNoticeNum) {
		return dao.selectTpNoticeNum(tpNoticeNum);
	}

	@Override
	public void removeNotice(int tpNoticeNum) {
		dao.deleteTpNotice(tpNoticeNum);
	}
	
	@Override
	public void tpNoticeWriter(TpNotice tpNotice) {
		dao.insertTpNotice(tpNotice);
	}

	@Override
	public void updateTpNotice(TpNotice tpNotice) {
		dao.updateTpNotice(tpNotice);
	}
	
}
