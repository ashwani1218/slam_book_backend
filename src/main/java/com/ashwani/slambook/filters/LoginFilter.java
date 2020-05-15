package com.ashwani.slambook.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter{

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
			
		}
		
		chain.doFilter(request, response);
		
	}

}
