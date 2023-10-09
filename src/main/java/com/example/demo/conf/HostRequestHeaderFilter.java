package com.example.demo.conf;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import com.example.demo.model.UserContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.RequestContextFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class HostRequestHeaderFilter extends RequestContextFilter {

	private static AtomicInteger counter = new AtomicInteger(0);

	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	UserContext context;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		int current = counter.getAndIncrement();
		context.setHost(request.getHeader("host"));
		log.info("#{} : context: {}", current, context);
		filterChain.doFilter(request, response);
	}

	@Override
	protected boolean shouldNotFilterAsyncDispatch() {
		return true;
	}

	@Override
	protected boolean shouldNotFilterErrorDispatch() {
		return true;
	}
}
