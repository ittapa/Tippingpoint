package kr.pe.tippingpoint.dao;

import java.util.List;

import kr.pe.tippingpoint.vo.TpFunder;


public interface TpFunderDao {
	
	int insertTpFunder(TpFunder tpFunder);//회원 가입후 회원추가

	int deleteTpFunderById(String tpfId);//회원 삭제

	int updateTpFunder(TpFunder tpFunder);//회원 정보 수정

	TpFunder selectTpFunderById(String tpfId);//회원 ID로 찾기

	List<TpFunder> selectTpFunders();//회원 전체 조회

	List<TpFunder> selectTpFundersPaging(int pageNo);//페이징처리

	List<TpFunder> selectTpFundersByName(String tpfName);//회원이름으로 찾기

	int selectCountTpFunders();//총회원수 조회

}
