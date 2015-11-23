package kr.pe.tippingpoint.service;

import java.util.List;
import java.util.Map;

import kr.pe.tippingpoint.vo.TpFunder;


public interface TpFunderAccountAccessService {
	
	/**
	 * 회원을 등록하는 메소드.
	 *  - 회원 id (id)는 중복될 수 없다.  
	 *  	- 등록하려는 회원의 id와 같은 id의 회원이 이미 등록된 경우 등록 처리 하지 않는다. 
	 * @param TpFunder 등록할 회원 정보를 가진 TpFunder객체를 받을 매개변수.
	 * @throws DuplicatedIdException 
	 */
	void addTpFunder(TpFunder tpFunder) throws Exception;

	/**
	 * 전체 회원들을 조회하는 메소드.
	 * @return
	 */
	List<TpFunder> getAllTpFunders();

	Map getAllTpFundersPaging(int pageNo);

	//	조회 메소드들
	/**
	 * id로 회원을 찾는 메소드
	 * @param id 조회할 회원의 ID
	 * @return TpFunderList에서 조회한 회원객체. 찾는 회원이 없으면 null을 리턴한다.
	  
	 */
	TpFunder findTpFunderById(String tpfId);

	/**
	 * 이름으로 회원을 조회하는 메소드
	 * @param name 조회할 회원의 이름
	 * @return TpFunderList에서 조회된 회원들을 담아 리턴할 ArrayList
	 */
	List<TpFunder> findTpFunderByName(String tpfName);

	/**
	 * 매개변수로 받은 ID의 회원을 찾아 삭제 처리
	 *  - 매개변수로 받은 ID의 회원이 없으면 처리를 진행하지 않는다. 
	 * @param id
	  
	 * @throws TpFunderNotFoundException 삭제할 회원이 DB에 없으면 발생
	 */
	void removeTpFunder(String tpfId) throws Exception;

	/**
	 * 매개변수로 받은 회원과 같은 ID를 가진 회원정보를 찾아 수정 처리.
	 *  - 수정하려는 회원의 ID가 없는 경우 처리를 진행하지 않는다.
	 * @param newCust 변경할 회원 정보
	 * @throws TpFunderNotFoundException 수정할 회원이 DB에 없으면 발생
	 */
	void updateTpFunder(TpFunder newTpFunder) throws Exception;
}
