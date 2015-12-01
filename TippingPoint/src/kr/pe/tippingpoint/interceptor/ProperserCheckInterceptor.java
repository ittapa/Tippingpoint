package kr.pe.tippingpoint.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import kr.pe.tippingpoint.service.TpFunderAccountAccessServiceImpl;

public class ProperserCheckInterceptor implements HandlerInterceptor {
	@Autowired
	private TpFunderAccountAccessServiceImpl service;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("------------프로젝트 등록 권한 확인------------");
		HttpSession session = request.getSession();
		if (!service.findTpFunderById(String.valueOf(session.getAttribute("userLoginInfo"))).getTpfQualifyTpProposer().equals("T")) {
			request.setAttribute("unProperser", "unProperser");
			// 안한경우 - ModelAndViewDefiningException 발생
			throw new ModelAndViewDefiningException(new ModelAndView("/tpProposer.tp"));
		}
		// 로그인한 사용자. ->handler(컨트롤러) 호출
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
