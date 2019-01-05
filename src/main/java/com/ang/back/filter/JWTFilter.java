package com.ang.back.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.ang.back.config.JWTFactory;

@Component
public class JWTFilter extends GenericFilterBean {

	private JWTFactory jf = new  JWTFactory();
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		if (uri.indexOf("login") == -1) {
			String id = req.getHeader("X-AUTH-ID");
			String token = req.getHeader("X-AUTH-TOKEN");// 앞에 X는 내가 만든거, 확장한거
			System.out.println("왜 안되는거야");
			System.out.println("***" + id + "*****" + token);
			if (id == null || token == null) {
				System.out.println(token + "+" + id);
				throw new ServletException("토큰값 확인");
			}
			try {
				jf.verifyJWT(id, token);
			} catch (Exception e) {
				throw new ServletException("아이디하고 토큰값  맞아?");
			}
		}
		chain.doFilter(request, response);
	}

}
