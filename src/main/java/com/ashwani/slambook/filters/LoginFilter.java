package com.ashwani.slambook.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.ashwani.slambook.util.JWTUtil;

public class LoginFilter implements Filter{
	
	@Autowired
	private JWTUtil jwtUtil;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		final HttpServletRequest req = (HttpServletRequest) request;
		final HttpServletResponse resp = (HttpServletResponse) response;
		
		String authHeader = req.getHeader("authorization");
		
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			throw new ServletException("Missing authorization Header");
		}
		else {
			String token = authHeader.substring(7);
			System.out.println(token);
			if(jwtUtil.validateToken(token)) {
				chain.doFilter(request, response);
			}
			else {
				resp.getWriter().write("Invalid token");
			}
		}
		
//		chain.doFilter(request, response);
		
	}

}
