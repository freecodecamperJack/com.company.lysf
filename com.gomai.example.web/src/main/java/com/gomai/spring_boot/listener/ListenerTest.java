package com.gomai.spring_boot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 
 * 〈定义监听器〉
 *
 * @author Administrator
 */
public class ListenerTest implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("===============监听器已销毁================");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("===============监听器初始化中...================");
	}
}
