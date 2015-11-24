package kr.pe.tippingpoint.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import kr.pe.tippingpoint.dao.TpProjectDao;
import kr.pe.tippingpoint.util.TpProjectBoardPagingBean;
import kr.pe.tippingpoint.util.TpSerchingProjectPagingBean;
import kr.pe.tippingpoint.vo.TpProject;

@Service
public class TpProjectServiceImpl implements TpProjectService {

	@Autowired
	private TpProjectDao dao;

	@Override
	public Map allListTpProject(int pageNo) {
		HashMap map = new HashMap();
		List<TpProject> list = dao.selectOTpProject(pageNo);
		TpProjectBoardPagingBean pagingBean = new TpProjectBoardPagingBean(dao.selectCountProject(), pageNo);
		map.put("list", list); // 목록에 뿌려질 고객들 정보
		map.put("pagingBean", pagingBean); // 페이징 처리위한 pagingBean

		return map;
	}

	@Override
	public TpProject findTpProjectById(String tppId) {
		return dao.selectTpProjectById(tppId);
	}

	@Override
	public List<TpProject> findToProjectByCategory(String tppCategory) {
		return null;
	}

	@Override
	public void registerTpProject(TpProject tpvo) {
		dao.insertTpProject(tpvo);
	}

	@Override
	public Map<String, Object> serchTpProjectByKeyWord(@RequestParam String keyWord) {
		Map<String, Object> map = new HashMap();
		List<TpProject> list = dao.serchTpProjectByKeyWord(keyWord);
		// TpSerchingProjectPagingBean pagingBean = new
		// TpSerchingProjectPagingBean(dao.selectCountProject(), pageNo);

		// map.put("pagingBean", pagingBean); //페이징 처리위한 pagingBean

		map.put("list", list); // 목록에 뿌려질 고객들 정보

		return map;

	}

	@Override
	public Map findTpProjectByWriter(String writer) {
		Map<String, Object> map = new HashMap();
		List<TpProject> list = dao.selectTpProjectByWriter(writer);
		map.put("list", list); // 목록에 뿌려질 고객들 정보
		return map;
	}

}
