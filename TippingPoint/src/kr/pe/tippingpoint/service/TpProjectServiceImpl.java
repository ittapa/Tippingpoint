package kr.pe.tippingpoint.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import kr.pe.tippingpoint.dao.TpProjectCategoryDaoImpl;
import kr.pe.tippingpoint.dao.TpProjectDao;
import kr.pe.tippingpoint.util.TpProjectBoardPagingBean;
import kr.pe.tippingpoint.util.TpSerchingProjectPagingBean;
import kr.pe.tippingpoint.vo.TpProject;
import kr.pe.tippingpoint.vo.TpProjectCategory;

@Service
public class TpProjectServiceImpl implements TpProjectService {

	@Autowired
	private TpProjectDao dao;


	//승인값이 o 인 프로젝트 검색

	@Override
	public Map allListTpProject(int pageNo) {
		HashMap map = new HashMap();
		List<TpProject> list = dao.selectOXEZCountProject(pageNo);
		TpProjectBoardPagingBean pagingBean = new TpProjectBoardPagingBean(dao.selectOEXZCountProject(), pageNo);
		map.put("list", list); // 목록에 뿌려질 고객들 정보
		map.put("pagingBean", pagingBean); // 페이징 처리위한 pagingBean

		return map;
	}

	@Override
	public TpProject findTpProjectById(String tppId) {
		return dao.selectTpProjectById(tppId);
	}

	
	//TODO 카테고리로 조회하기
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

	
	//카테고리 DB 호출
	@Autowired
	private TpProjectCategoryDaoImpl catedao; 
	@Override
	public List<TpProjectCategory> tpProjectCategoryList() {
		System.out.println(catedao.selectTpProjectCategory());
		
		return catedao.selectTpProjectCategory();
		
	}

	//////////////////////////////////////첫번째 수정 //////////////////////////////////////
	

	@Override
	public Map selectCategoryProject(int pageNo, String tppCategory) {
		HashMap map = new HashMap();
		List<TpProject> list = dao.selectCategoryProjectDao(pageNo,tppCategory);
		TpProjectBoardPagingBean pagingBean = new TpProjectBoardPagingBean(dao.selectOAndCTCountProject(tppCategory), pageNo);
		map.put("list", list); // 목록에 뿌려질 고객들 정보
		map.put("pagingBean", pagingBean); // 페이징 처리위한 pagingBean

		return map;
	}
	
	//업데이트 프로젝트
	@Override
	public void updateTpProject(TpProject tpproject) {
		
		dao.updateTpProjectById(tpproject);
	}
	
	
	
	
	
}

