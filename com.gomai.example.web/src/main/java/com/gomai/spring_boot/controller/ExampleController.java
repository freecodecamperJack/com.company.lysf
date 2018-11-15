package com.gomai.spring_boot.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * 〈demo example〉
 *
 * @author weinan
 */
@Controller
@RequestMapping("example")
public class ExampleController {
	
	@RequestMapping("/")
	@ResponseBody
	public String index() {
		return "hello Spring Boot";
	}
	
	@RequestMapping("hello")
	public String hello(Map<String, Object> map) {
		map.put("msg", "Hello Freemarker!");
		return "hello";
	}
	
	/**
	 * 
	 *〈去往manage页面〉<br>
	 * 
	 * @author weinan <br> 
	 *		   2018年9月14日
	 * @update 
	 * @return  String
	 * @since [起始版本]
	 */
	@RequestMapping("manage")
	public String manage() {
		return "manage";
	}
}
