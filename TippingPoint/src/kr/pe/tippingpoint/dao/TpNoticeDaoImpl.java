package kr.pe.tippingpoint.dao;

import java.util.HashMap;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.pe.tippingpoint.util.TpNoticeBoardPagingBean;
import kr.pe.tippingpoint.vo.TpNotice;
import kr.pe.tippingpoint.vo.TpProject;

@Repository
public class TpNoticeDaoImpl implements TpNoticeDao{

	@Autowired
	private SqlSessionTemplate session;

	@Override
	public List<TpProject> selectAllTpNotice(int pageNo) {
		HashMap<String, Integer> parameter = new HashMap<String, Integer>();
		parameter.put("contentPerPage", TpNoticeBoardPagingBean.CONTENT_PER_PAGE);
		parameter.put("pageNo", pageNo);
		return session.selectList("tpNoticeMapper.selectTpNoticePaging", parameter);
	}

	@Override
	public int selectCountTpNotice() {
		return session.selectOne("tpNoticeMapper.selectCountTpNotice");
	}
	
	@Override
	public TpNotice selectTpNoticeNum(int tpNoticeNum) {

		return session.selectOne("tpNoticeMapper.selectTpNoticeByNum", tpNoticeNum);
	}

	@Override
	public int insertTpNotice(TpNotice tpnotice) {
		return session.insert("tpNoticeMapper.insertTpNotice",tpnotice);
	}

	@Override
	public int deleteTpNotice(String tppId) {
		return session.delete("tpNoticeMapper.deleteTpNotice",tppId);
	}

	@Override
	public int updateTpNotice(TpNotice tpnotice) {
		return session.update("tpNoticeMapper.updateTpNotice",tpnotice);
	}
	
	

}
