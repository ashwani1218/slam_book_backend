package com.ashwani.slambook.filters;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FilterRegistration {

	@Bean
	public FilterRegistrationBean<LoginFilter> loginFilter(){
		
		FilterRegistrationBean<LoginFilter> loginBean	= new FilterRegistrationBean<>();
		
		loginBean.setFilter(new LoginFilter());
		loginBean.addUrlPatterns("/v1/api/*");
		
		return loginBean;
	}
}
