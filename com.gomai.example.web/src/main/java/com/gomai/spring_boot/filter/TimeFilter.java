package com.gomai.spring_boot.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 * 〈自定义过滤器/第三方过滤器〉
 *
 * @author Administrator
 */
public class TimeFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("================过滤器销毁===============");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long start = System.currentTimeMillis();

		chain.doFilter(request, response);

		System.out.println("filter耗时：" + (System.currentTimeMillis() - start));
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("================过滤器初始化===============");
	}
}
