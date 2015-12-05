package kr.pe.tippingpoint.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import kr.pe.tippingpoint.dao.TpProjectCategoryDaoImpl;
import kr.pe.tippingpoint.service.TpProjectServiceImpl;

public class PagNavInterceptor implements HandlerInterceptor {

	@Autowired
	TpProjectCategoryDaoImpl cateDao;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String servletPath = request.getServletPath();
			System.out.println("서블릿 패스"+servletPath);
		String pageNavMidCate = null;
		String pageNavThirdCate = null;
			
		
		if(servletPath.equals("/tpHelpPage.tp")){
			pageNavThirdCate = "HELP";
		}else if(servletPath.equals("/tpNoticeBoard.tp")){
			pageNavThirdCate = "공지사항";
		}else if(servletPath.equals("/tpProjectBoard.tp")){
			pageNavMidCate = "프로젝트 둘러보기";
			pageNavThirdCate = "모두보기";
		}else if(servletPath.equals("/tpProjectCategoryBoard.tp")){
			pageNavMidCate = "프로젝트 둘러보기";
			pageNavThirdCate = request.getParameter("tppCategory");		
		}else if(servletPath.equals("/tpProjectRegisterForm.tp")){
			pageNavThirdCate = "프로젝트 등록하기";
		}else if(servletPath.equals("/tpfunder/registerForm.tp")){
			pageNavMidCate = "회원가입";
		}else if(servletPath.equals("/tpLogin/tpLoginPage.tp")){
			pageNavMidCate = "LOGIN";
		}else if(servletPath.equals("/modifyForm.tp")){
			pageNavMidCate = "MY PAGE";
			pageNavThirdCate = "회원정보 수정";
		}else if(servletPath.equals("/searchByWriterProject.tp")){
			pageNavMidCate = "MY PAGE";
			pageNavThirdCate = "내가 등록한 프로젝트";
		}else if(servletPath.equals("/tpProposer.tp")){
			pageNavMidCate = "MY PAGE";
			pageNavThirdCate = "PROPOSER";
		}else if(servletPath.equals("/tpAdministrator/tpAdminMain.tp")){
			pageNavThirdCate = "관리자 페이지";
			
			
		}else if(servletPath.equals("/tpProject.tp")){
			pageNavMidCate = "프로젝트";
			pageNavThirdCate = "상세보기";
			
		}else if(servletPath.equals("/tpProjectModifyForm.tp")){
			pageNavMidCate = "MY PAGE";
			pageNavThirdCate = "프로젝트 수정하기";
			
		}else if(servletPath.equals("/tpAdminProjectBoard.tp")){
			pageNavMidCate = "관리자 페이지";
			pageNavThirdCate = "프로젝트 모두보기";
			
		}else if(servletPath.equals("/tpAdminCategoryProjectBoard.tp")){
			pageNavMidCate = "관리자 페이지";
						if(request.getParameter("check").equals("B")){
							pageNavThirdCate = "저장된 프로젝트";
						}else if(request.getParameter("check").equals("A")){
							pageNavThirdCate = "승인요청 프로젝트";
						}else if(request.getParameter("check").equals("X")){
							pageNavThirdCate = "승인거부 프로젝트";
						}else if(request.getParameter("check").equals("O")){
							pageNavThirdCate = "승인완료 프로젝트";
						}else if(request.getParameter("check").equals("E")){
							pageNavThirdCate = "펀딩종료 프로젝트";
						}else if(request.getParameter("check").equals("Z")){
							pageNavThirdCate = "펀딩마감 프로젝트";
						}
			
		}else if(servletPath.equals("/findAllTpFunderList.tp")){
			pageNavMidCate = "관리자 페이지";
			pageNavThirdCate = "회원 목록";
		}else if(servletPath.equals("/findByTpfId.tp?p")){
			pageNavMidCate = "관리자 페이지";
			pageNavThirdCate = "회원 정보 상세보기";
		}else if(servletPath.equals("/tpAdminNoticeManager.tp")){
			pageNavMidCate = "관리자 페이지";
			pageNavThirdCate = "공지사항";
		}else if(servletPath.equals("/adminFindTpNotice.tp")){
			pageNavMidCate = "관리자 페이지";
			pageNavThirdCate = "공지사항 상세보기";
		}else if(servletPath.equals("/modifyNotice.tp")){
			pageNavMidCate = "관리자 페이지";
			pageNavThirdCate = "공지사항 수정하기";
		}else if(servletPath.equals("/tpNotice/tpNoticeWriter.tp")){
			pageNavMidCate = "관리자 페이지";
			pageNavThirdCate = "공지사항 작성하기";
		}
		
		
		else if(servletPath.equals("/tpAdminCheckAndCategoryMain.tp")||servletPath.equals("catrgoryController.tp")){
			pageNavMidCate = "관리자 페이지";
			pageNavThirdCate = "카테고리목록 관리";
		}
		else if(servletPath.equals("/tpAdminCheckAndBankMain.tp") || servletPath.equals("/bankController.tp")){
			pageNavMidCate = "관리자 페이지";
			pageNavThirdCate = "은행목록 관리";
		}
	
		
		/*else if(servletPath.equals("/tpNotice/tpNoticeWriter.tp")){
			pageNavMidCate = "관리자 페이지";
			pageNavThirdCate = "공지사항 상세보기";
		}
		*/
		
		

		
		
		request.setAttribute("pageNavMidCate", pageNavMidCate);
		request.setAttribute("pageNavThirdCate", pageNavThirdCate);
		
		request.setAttribute("categoryList", cateDao.selectTpProjectCategory());
		request.setAttribute("url", request.getRequestURI());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	
}
