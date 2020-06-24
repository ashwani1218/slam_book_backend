package com.ashwani.slambook.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@Component
public class LoginFilter implements Filter {

//	private static final Logger LOGGER = LoggerFactory.getLogger(LoginFilter.class);
//
//	private JWTUtil jwtUtil = new JWTUtil();

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

//		final HttpServletRequest req = (HttpServletRequest) request;
//		final HttpServletResponse resp = (HttpServletResponse) response;
//		resp.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
//		resp.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
//		resp.setHeader("Access-Control-Allow-Headers", "Authorization,X-Requested-With,Origin,Accept,"
//				+ "Access-Control-Allow-Credentials,Access-Control-Allow-Headers,Access-Control-Allow-Methods,Access-Control-Allow-Origin"
//				+ "Access-Control-Expose-Headers,Access-Control-Max-Age,Access-Control-Request-Headers"
//				+ ",Access-Control-Request-Method,Age,Allow,Alternates,Content-Range,Content-Disposition,Content-Description "
//				+ ", authorization ,X-Auth-Token, Content-Type");
//		resp.setHeader("Access-Control-Expose-Headers", "Authorization, Content-Type");
//		resp.setHeader("Access-Control-Allow-Credentials", "true");
//		resp.setHeader("Access-Control-Max-Age", "4800");
//		
////		String authHeader = req.getHeader("Authorization");
////		Cookie[] cookies = req.getCookies();
//		
//		
//		String authHeader="";
//		for (Cookie c : req.getCookies()) {
//            if (c.getName().equals("token"))
//                authHeader =  c.getValue();
//            }
//		LOGGER.info("token from cookie: {}", authHeader);
//		
////		= Arrays.stream(cookies)
////	            .filter(c -> c.getName().equals("token"))
////	            .findFirst()
////	            .map(Cookie::getValue)
////	            .orElse(null);
////		
//		LOGGER.info("Header {}", authHeader);
//
//		if (authHeader == null ) {
//			throw new ServletException("Missing authorization Header");
//		} else {
////			String token = authHeader.substring(7);
//			String token = authHeader;
//			LOGGER.info("Token: {}", token);
//			Boolean isValid = jwtUtil.validateToken(token);
//			LOGGER.info("isValid: {}", isValid);
//			if (isValid) {

				chain.doFilter(request, response);
//			} else {
//				throw new CustomException("Invalid Token", HttpStatus.UNAUTHORIZED);
//			}
//		}
//
	}

}
