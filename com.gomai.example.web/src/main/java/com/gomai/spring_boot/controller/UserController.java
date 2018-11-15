package com.gomai.spring_boot.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gomai.spring_boot.data.UserData;

/**
 * 
 * 〈用户controller〉
 *
 * @author Administrator
 */
@Controller
@RequestMapping("user")
public class UserController {

	@RequestMapping("/userInfo")
	@ResponseBody
	public UserData getUserInfo() {
		UserData userData = new UserData("10000", "张三", "zhangsan001", new Date(), "this is remark!");
		return userData;
	}
}
