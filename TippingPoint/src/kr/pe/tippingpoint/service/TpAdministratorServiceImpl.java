package kr.pe.tippingpoint.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.tippingpoint.dao.TpProjectDao;
import kr.pe.tippingpoint.util.TpAdminProjectBoardPagingBean;
import kr.pe.tippingpoint.util.TpProjectBoardPagingBean;
import kr.pe.tippingpoint.vo.TpProject;

@Service
public class TpAdministratorServiceImpl implements TpAdministratorService {

	@Autowired
	private TpProjectDao dao;
	
	@Override
	//모든 프로젝트 조회
	public Map adminAllListTpProject(int pageNo) {
		HashMap map = new HashMap();
		List<TpProject> list = dao.selectAllTpProject(pageNo);
		TpAdminProjectBoardPagingBean pagingBean = new TpAdminProjectBoardPagingBean(dao.selectCountProject(), pageNo);
		map.put("list", list); //목록에 뿌려질 고객들 정보
		map.put("pagingBean", pagingBean); //페이징 처리위한 pagingBean
	return map;
	}

	//조회
	@Override
	public TpProject adminFindTpProjectById(String tppId) {
		return dao.selectTpProjectById(tppId);
	}
	
	//up

	@Override
	public void adminProjectUp(TpProject adminProject) {
		dao.adminUpById(adminProject);
	}
	
	
	
	

}
