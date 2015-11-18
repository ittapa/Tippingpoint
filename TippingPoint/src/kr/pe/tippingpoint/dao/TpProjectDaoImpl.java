package kr.pe.tippingpoint.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.pe.tippingpoint.util.PagingBean;
import kr.pe.tippingpoint.vo.TpProject;

@Repository
public class TpProjectDaoImpl implements TpProjectDao{
	
	@Autowired
	private SqlSessionTemplate session;

	@Override
	public List<TpProject> selectAllTpProject(int pageNo) {
		HashMap<String, Integer> parameter = new HashMap<String, Integer>();
		parameter.put("contentPerPage", PagingBean.CONTENT_PER_PAGE);
		parameter.put("pageNo", pageNo);
		return session.selectList("tpProjectMapper.selectTpProjectPaging", parameter);
	}

	@Override
	public int selectCountProject() {
		return session.selectOne("tpProjectMapper.selectCountProject");
	}

	@Override
	public TpProject selectTpProjectById(String tppId) {
		return session.selectOne("tpProjectMapper.selectTpProjectById", tppId);
	}

	@Override
	public List<TpProject> selectByCategory(String tppCategory) {
		return null;
	}

	@Override
	public int insertTpProject(TpProject tpproject) {
		return session.insert("tpProjectMapper.insertTpProject",tpproject);
	}

	@Override
	public int deleteById(String tppId) {
		return 0;
	}

	@Override
	public int updateById(TpProject tpproject) {
		return 0;
	}

	@Override
	public void adminUpById(TpProject adminProjecte) {
		session.update("tpProjectMapper.adminProjectUpdate",adminProjecte);
	}
	
	
}
