package kr.pe.tippingpoint.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.tippingpoint.dao.TpBankListDao;
import kr.pe.tippingpoint.dao.TpBankListDaoImpl;
import kr.pe.tippingpoint.dao.TpProjectCategoryDao;
import kr.pe.tippingpoint.dao.TpProjectDao;
import kr.pe.tippingpoint.util.TpAdminProjectBoardPagingBean;
import kr.pe.tippingpoint.util.TpProjectBoardPagingBean;
import kr.pe.tippingpoint.vo.TpBankList;
import kr.pe.tippingpoint.vo.TpProject;
import kr.pe.tippingpoint.vo.TpProjectCategory;

@Service
public class TpAdministratorServiceImpl implements TpAdministratorService {

	@Autowired
	private TpProjectDao dao;

	@Autowired
	private TpProjectCategoryDao categoryDao;
	
	@Autowired
	private TpBankListDao bankDao;
	
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

	
	
	

	////////////////////////////첫번째 수정 //////////////////////////
	@Override
	public Map adminCategoryProject(int pageNo, String check) {
		HashMap map = new HashMap();
		List<TpProject> list = dao.adminCategoryProjectDao(pageNo,check);
		TpProjectBoardPagingBean pagingBean = new TpProjectBoardPagingBean(dao.adminCheckCountProject(check), pageNo);
		map.put("list", list); // 목록에 뿌려질 고객들 정보
		map.put("pagingBean", pagingBean); // 페이징 처리위한 pagingBean

		return map;
	}
	


	////////////////////////////카테고리 관련 페이지 //////////////////////////
	@Override
	public void addTpCategory(String tppCategory, String tppCategoryName) {
		categoryDao.insertTpProjectCategoryByCategory(tppCategory,tppCategoryName);
	}

	@Override
	public void deleteTpCategory(String tppCategoryName) {
		categoryDao.deleteTpProjectCategoryByCategory(tppCategoryName);
	}

	@Override
	public void updateTpCategory(TpProjectCategory category, String updateCategory) {
		categoryDao.updateTpProjectCategoryByCategory(category, updateCategory);
	}
	//////////////////////////////////은행 관리 페이지/////////////////////////////////////////////

	@Override
	public void addBank(String bankKr, String bankEr, String code) {
		bankDao.insertBankListByCode(bankKr, bankEr, code);
		
	}

	@Override
	public void deleteBank(String bankKr) {
		bankDao.deleteBankListById(bankKr);
		
	}

	@Override
	public void updateBank(String updateBank, TpBankList bankList) {
		bankDao.updateBankList(updateBank, bankList);
		
	}

	
	

}
