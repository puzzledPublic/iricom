package com.company.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class DbgAccessDeniedHandler implements AccessDeniedHandler{

	private String errorPage;
	
	public void setErrorPage(String errorPage){
		if((errorPage != null) &&!errorPage.startsWith("/")){
			throw new IllegalArgumentException("ErrorPage Must begin with '/'");
		}
		this.errorPage = errorPage;
	}
	//access deny 될때 사용 되는 핸들러.
	//ajax 요청의 경우와 일반적인 경우로 나눠 처리 
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//ajax 식별자를 넘겨 받음 
		String ajaxHeader = request.getHeader("Ajax-call");
		String result = "";
		//response status 403
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		response.setCharacterEncoding("UTF-8");
		//일반적인 상황(ajax 식별자가 없는 경우)
		if(ajaxHeader == null){
			request.setAttribute("errorMsg", accessDeniedException);
			request.getRequestDispatcher(errorPage).forward(request, response);
		}
		//ajax 상황
		else{
			if(ajaxHeader.equals("true")){
				result += "{\"result\":\"fail\",\"message\":\"" + accessDeniedException.getMessage() + "\"}";
			}
			else{
				result += "{\"result\":\"fail\",\"message\":\"Access Denied(Header Value MisMatch)\"}";
			}
		}
		
		response.getWriter().print(result);
		response.getWriter().flush();
	}

}
