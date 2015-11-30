package kr.pe.tippingpoint.service;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.tippingpoint.dao.TpBankListDaoImpl;
import kr.pe.tippingpoint.dao.TpFunderDaoImpl;
import kr.pe.tippingpoint.dao.TpProposerDao;
import kr.pe.tippingpoint.exception.DuplicatedIdException;
import kr.pe.tippingpoint.exception.TpFunderNotFoundException;
import kr.pe.tippingpoint.util.TpFunderPagingBean;
import kr.pe.tippingpoint.vo.TpBankList;
import kr.pe.tippingpoint.vo.TpFunder;
import kr.pe.tippingpoint.vo.TpProposer;


@Service
public class TpFunderAccountAccessServiceImpl implements TpFunderAccountAccessService{
	
	@Autowired
	private TpFunderDaoImpl dao;
	
	@Autowired
	private TpProposerDao pdao;
	
	
	
	public TpFunderAccountAccessServiceImpl() {}
	
	@Override
	public void addTpFunder(TpFunder tpFunder) throws DuplicatedIdException {
		TpFunder tpfr = dao.selectTpFunderById(tpFunder.getTpfId());
		if(tpfr != null){
			//이미 있는 고객ID이므로 예외발생 시킨다.
			throw new DuplicatedIdException(tpFunder.getTpfId()+"는 이미 등록된 ID입니다.");
		}
		//DB에 insert 
		dao.insertTpFunder(tpFunder);
	}

	@Override
	public List<TpFunder> getAllTpFunders() {
		return dao.selectTpFunders();
	}

	@Override
	public Map getAllTpFundersPaging(int pageNo) {
		HashMap map = new HashMap();
		map.put("list", dao.selectTpFundersPaging(pageNo));
		TpFunderPagingBean pagingBean = new TpFunderPagingBean(dao.selectCountTpFunders(), pageNo);
		map.put("pagingBean", pagingBean);
		return map;
	}
	
	@Override
	public TpFunder findTpFunderById(String tpfId) {
		return dao.selectTpFunderById(tpfId);
	}

	@Override
	public List<TpFunder> findTpFunderByName(String tpfName) {
		return dao.selectTpFundersByName(tpfName);
	}

	@Override
	public void removeTpFunder(String tpfId) throws Exception {
		TpFunder tpfr = dao.selectTpFunderById(tpfId);
		if(tpfr==null){
//			throw new CustomerNotFoundException(tpfId+"는 없는 ID이므로 삭제할 수 없습니다.");
		}
		dao.deleteTpFunderById(tpfId);
	}

	@Override
	public void updateTpFunder(TpFunder newTpFunder) throws Exception {
		TpFunder tpfr = dao.selectTpFunderById(newTpFunder.getTpfId());
		if(tpfr==null){
			throw new TpFunderNotFoundException(newTpFunder.getTpfId()+"는 없는 ID이므로 수정할 수 없습니다.");
		}
		dao.updateTpFunder(newTpFunder);
	}


	
	@Override
	public void addProposerInfo(TpProposer tposer, String writer) throws Exception{
		pdao.insertInfo(tposer);
		
		Map map = new HashMap();
		map.put("tppId", tposer.getTpfId());
		map.put("value", "T");
		dao.updateTpFunderQuqlifyTpProposer(map);
	}

	
	//////////////////////////////////////////////수정중 얘 필요없ㅇ므/////////////////////////////////////////////////
	@Override
	public void addTpfQualFytpproposer(String writer) throws Exception {
		//pdao.addTpfQualFy(t);
	}
	
	@Autowired
	private TpBankListDaoImpl bkdao;
	
	@Override
	public List<TpBankList> getAllBankList() {
			
		return bkdao.allTpBankList();
	}
	
	@Override
	public TpProposer selectTpProposerById(String tpfId) {
		return pdao.selectProposer(tpfId);
	}
	
	@Override
	public void updateInfo(TpProposer rposer) throws Exception {
		// TODO Auto-generated method stub
		pdao.updateInfo(rposer);
	}
	
	//폰넘버로 펀더 조회 _ 아이디 찾기를 위해
	@Override
	public TpFunder findTpFunderByPhoneNum(String tpfPhoneNum) {
		return dao.selectTpFundersByPhoneNum(tpfPhoneNum);
	}
}
