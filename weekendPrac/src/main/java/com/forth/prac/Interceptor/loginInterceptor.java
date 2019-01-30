package com.forth.prac.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class loginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		String loginId=(String)session.getAttribute("loginId");
		
		if(loginId==null) {
								//어플리케이션 이름
			response.sendRedirect(request.getContextPath() +"/goLogin");
			return false;
		}
		
		return super.preHandle(request, response, handler);
	}
	
	
}
