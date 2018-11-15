package com.gomai.spring_boot.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 〈自定义拦截器〉
 *
 * @author Administrator
 */
@Component  // 生命周期交由spring管理
public class TimeInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("=======================afterCompletion====================");
		long startTime = (Long) request.getAttribute("startTime");
		System.out.println("耗时：" + (System.currentTimeMillis() - startTime));
		System.out.println(ex);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("=======================postHandle====================");
		long startTime = (Long) request.getAttribute("startTime");
		System.out.println("耗时：" + (System.currentTimeMillis() - startTime));
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("========================preHandle================");
		System.out.println(((HandlerMethod) handler).getBean().getClass().getName());
		System.out.println(((HandlerMethod) handler).getMethod().getName());

		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}

}
