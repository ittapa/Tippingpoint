package kr.pe.tippingpoint.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.pe.tippingpoint.util.TpProjectBoardPagingBean;
import kr.pe.tippingpoint.vo.TpProject;

@Repository
public class TpProjectDaoImpl implements TpProjectDao{
	
	@Autowired
	private SqlSessionTemplate session;

	
	//프로젝트 전체보기
	@Override
	public List<TpProject> selectAllTpProject(int pageNo) {
		HashMap<String, Integer> parameter = new HashMap<String, Integer>();
		parameter.put("contentPerPage", TpProjectBoardPagingBean.CONTENT_PER_PAGE);
		parameter.put("pageNo", pageNo);
		return session.selectList("tpProjectMapper.selectTpProjectPaging", parameter);
	}
	
	
	//프로젝트 전체보기 ('OXEZ')인것만
	@Override
	public List<TpProject> selectOXEZCountProject(int pageNo) {
		HashMap<String, Integer> parameter = new HashMap<String, Integer>();
		parameter.put("contentPerPage", TpProjectBoardPagingBean.CONTENT_PER_PAGE);
		parameter.put("pageNo", pageNo);
		return session.selectList("tpProjectMapper.selectOXEZTpProjectPaging", parameter);
	}

	//프로젝트 전체보기 ('A')인것만
	@Override
	public List<TpProject> selectATpProject(int pageNo) {
		HashMap<String, Integer> parameter = new HashMap<String, Integer>();
		parameter.put("contentPerPage", TpProjectBoardPagingBean.CONTENT_PER_PAGE);
		parameter.put("pageNo", pageNo);
		return session.selectList("tpProjectMapper.selectATpProjectPaging", parameter);
	}

	@Override
	public int selectCountProject() {
		return session.selectOne("tpProjectMapper.selectCountProject");
	}
	
	@Override
	public int selectOEXZCountProject() {
		return session.selectOne("tpProjectMapper.selectOEXZCountProject");
	}

	@Override
	public int selectACountProject() {
		return session.selectOne("tpProjectMapper.selectACountProject");
	}


	@Override
	public TpProject selectTpProjectById(String tppId) {
		return session.selectOne("tpProjectMapper.selectTpProjectById", tppId);
	}

	//todo : 카테고리 검색 햐야함
	@Override
	public List<TpProject> selectByCategory(String tppCategory) {
		return null;
	}
	
	// 프로젝트 추가하기
	@Override
	public int insertTpProject(TpProject tpproject) {
		return session.insert("tpProjectMapper.insertTpProject",tpproject);
	}

	//프로젝트 삭제하기
	@Override
	public int deleteById(String tppId) {
		return 0;
	}

	@Override
	public int updateTpProjectById(TpProject tpproject) {
		return session.delete("tpProjectMapper.updateTpProjectById", tpproject);
	}

	@Override
	public void adminUpById(TpProject adminProjecte) {
		session.update("tpProjectMapper.adminProjectUpdate",adminProjecte);
	}

	
	//프로젝트 키워드검색하기
	@Override
	public List<TpProject> serchTpProjectByKeyWord(String keyWord) {
		return session.selectList("tpProjectMapper.serchProjectByKeyWord", keyWord);
	
	}

	@Override
	public List<TpProject> selectTpProjectByWriter(String writer) {
		return session.selectList("tpProjectMapper.selectTpProjectByWriter", writer);
	}


	
	//////////////////////// 첫번째 수정 //////////////////////////////

	@Override
	public List<TpProject> selectCategoryProjectDao(int pageNo, String tppCategory) {
		HashMap parameter = new HashMap();
		parameter.put("contentPerPage", TpProjectBoardPagingBean.CONTENT_PER_PAGE);
		parameter.put("pageNo", pageNo);
		parameter.put("tppCategory", tppCategory);
		return session.selectList("tpProjectMapper.selectOAndCategoryTpProjectPaging", parameter);
	}


	@Override
	public int selectOAndCTCountProject(String tppCategory) {
		return session.selectOne("tpProjectMapper.selectOAndCategoryCountProject");
	}


	@Override
	public List<TpProject> adminCategoryProjectDao(int pageNo, String check) {
		HashMap parameter = new HashMap();
		parameter.put("contentPerPage", TpProjectBoardPagingBean.CONTENT_PER_PAGE);
		parameter.put("pageNo", pageNo);
		parameter.put("check", check);
		return session.selectList("tpProjectMapper.adminCheckCategory", parameter);
	}

	@Override
	public int adminCheckCountProject(String check) {
		return session.selectOne("tpProjectMapper.adminCheckCountProject",check);
	}

	
	
	@Override
	public int addFndrNumAndTotalAmount(TpProject tpproject) {
		return session.update("tpProjectMapper.addFndrNumAndTotalAmount", tpproject);
	}


	@Override
	public int minusFndrNumAndTotalAmount(TpProject tpproject) {
		return session.update("tpProjectMapper.minusFndrNumAndTotalAmount", tpproject);
	}
	
}
