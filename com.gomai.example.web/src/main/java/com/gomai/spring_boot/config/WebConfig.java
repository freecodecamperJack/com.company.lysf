package com.gomai.spring_boot.config;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.gomai.spring_boot.filter.TimeFilter;
import com.gomai.spring_boot.interceptor.TimeInterceptor;
import com.gomai.spring_boot.listener.ListenerTest;
import com.gomai.spring_boot.servlet.ServletTest;

/**
 * 〈web config〉
 * 
 * @author [作者]（必须，使用汉语）
 */
@SuppressWarnings("deprecation")
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
	private TimeInterceptor timeInterceptor;

	/*
	 * 1.需要先定义一个convert转换消息的对象； 2.添加fastjson的配置信息，比如是否要格式化返回的json数据
	 * 3.在convert中添加配置信息 4.将convert添加到converters中
	 */
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		// 1.定义一个convert消息转换器
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
		// 2.添加fastjson的配置信息，比如：是否要格式化返回json数据
		FastJsonConfig fConfig = new FastJsonConfig();
		fConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		// 处理json消息中文乱码
		List<MediaType> fastMediaType = new ArrayList<>();
		fastMediaType.add(MediaType.APPLICATION_JSON_UTF8);
		fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaType);
		fastJsonHttpMessageConverter.setFastJsonConfig(fConfig);
		HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
		System.out.println("==========json消息转换器配置成功============");
		return new HttpMessageConverters(converter);
	}
	
	/**
	 * 
	 *〈注册servlet〉<br>
	 * 
	 * @author weinan <br> 
	 *		   2018年9月14日
	 * @update 
	 * @param [参数1]     [参数1说明]
	 * @return  ServletRegistrationBean
	 * @since [1.0.0]
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Bean
	public ServletRegistrationBean<Servlet> servletRegistrationBean(){
		return new ServletRegistrationBean(new ServletTest(), "/servletTest");
	}
	
	/**
	 * 
	 *〈注册过滤器〉<br>
	 * 
	 * @author weinan <br> 
	 *		   2018年9月14日
	 * @update 
	 * @param [参数1]     [参数1说明]
	 * @return  FilterRegistrationBean
	 * @since [1.0.0]
	 */
	@Bean
	public FilterRegistrationBean<Filter> filterRegistrationBean(){
		FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
		
		TimeFilter timeFilter = new TimeFilter();
		registrationBean.setFilter(timeFilter);
		
		List<String> urls = new ArrayList<>();
		urls.add("/*");
		registrationBean.setUrlPatterns(urls);
		return registrationBean;
	}
	
	/**
	 * 
	 *〈注册监听器〉<br>
	 * 
	 * @author weinan <br> 
	 *		   2018年9月14日
	 * @update 
	 * @param [参数1]     [参数1说明]
	 * @return  ServletListenerRegistrationBean
	 * @since [1.0.0]
	 */
	@Bean
	public ServletListenerRegistrationBean<ServletContextListener> servletListenerRegistrationBean(){
		return new ServletListenerRegistrationBean<ServletContextListener>(new ListenerTest());
	}

	/**
	 * 
	 *〈注册拦截器〉<br>
	 * 
	 * @author weinan <br> 
	 *		   2018年9月14日
	 * @update 
	 * @param [参数1]     [参数1说明]
	 * @return  void
	 * @since [1.0.0]
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(timeInterceptor);
	}
	
}
