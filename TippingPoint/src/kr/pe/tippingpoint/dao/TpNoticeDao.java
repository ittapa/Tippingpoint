package kr.pe.tippingpoint.dao;

import java.util.List;

import kr.pe.tippingpoint.vo.TpNotice;
import kr.pe.tippingpoint.vo.TpProject;

public interface TpNoticeDao {

	public List<TpProject> selectAllTpNotice(int pageNo);

	public int selectCountTpNotice();

	public TpNotice selectTpNoticeNum(int tpNoticeNum);

	public int insertTpNotice(TpNotice tpnotice);

	public int deleteTpNotice(String tppId);

	public int updateTpNotice(TpNotice tpnotice);
	
}
