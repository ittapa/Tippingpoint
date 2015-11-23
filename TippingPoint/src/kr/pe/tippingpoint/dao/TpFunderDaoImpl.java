package kr.pe.tippingpoint.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.pe.tippingpoint.util.TpFunderPagingBean;
import kr.pe.tippingpoint.vo.TpFunder;

/**
 * 
 * TpFunder테이블과 연동하는 DAO 클래스
 * 
 * Transaction은 Business Service(CustomerService)에서 처리해야 하므로 
 * 모든 메소드들은 Connection을 받아서 처리한다.
 */
@Repository
public class TpFunderDaoImpl implements TpFunderDao {

	@Autowired
	private SqlSessionTemplate session;//no-arg생성자로 객체생성후 instance변수에 바로 주입
	
	public TpFunderDaoImpl(SqlSessionTemplate session) {
		this.session = session;
	}
	
	public TpFunderDaoImpl() {}

	@Override
	public int insertTpFunder(TpFunder tpFunder) {
		return session.insert("tpFunderMapper.insertTpFunder", tpFunder);
	}

	@Override
	public int deleteTpFunderById(String tpfId) {
		return session.delete("tpFunderMapper.deleteTpFunderById", tpfId);
	}

	@Override
	public int updateTpFunder(TpFunder tpFunder) {
		return session.update("tpFunderMapper.updateTpFunder", tpFunder);
	}

	@Override
	public TpFunder selectTpFunderById(String tpfId) {
		return session.selectOne("tpFunderMapper.selectTpFunderById", tpfId);
	}

	@Override
	public List<TpFunder> selectTpFunders() {
		return session.selectList("tpFsunderMapper.selectTpFunders");
	}

	@Override
	public List<TpFunder> selectTpFundersPaging(int pageNo) {
		HashMap map = new HashMap();
		map.put("contentsPerPage", TpFunderPagingBean.CONTENTS_PER_PAGE);
		map.put("pageNo", pageNo);
		List<TpFunder> list = session.selectList("tpFunderMapper.selectTpFundersPaging", map);
		return list;
	}

	@Override
	public List<TpFunder> selectTpFundersByName(String tpfName) {
		return session.selectList("tpFunderMapper.selectTpFunders");
	}

	@Override
	public int selectCountTpFunders() {
		return session.selectOne("tpFunderMapper.selectCountTpFunders");
	}
	
	
	
}
