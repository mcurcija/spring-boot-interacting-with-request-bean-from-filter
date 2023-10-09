package com.example.demo.conf;

import com.example.demo.model.UserContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.filter.RequestContextFilter;

@Configuration
public class WebConfig {

	/**
	 * Returns "request scoped" instance of {@link UserContext}.
	 * 
	 * @return the {@link UserContext} instance
	 */
	@Bean
	@RequestScope
	public UserContext userContext() {
		return new UserContext();
	}

	/**
	 * In order to access request scoped bean from {@link RequestContextFilter}
	 * instance an instance of {@link RequestContextListener} have to be provided. 
	 * 
	 * https://stackoverflow.com/a/30257691
	 * 
	 * return the {@link RequestContextListener} instance
	 */
	@Bean
	public RequestContextListener requestContextListener() {
		return new RequestContextListener();
	}

}
