package com.gomai.spring_boot.unit;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gomai.spring_boot.data.UserData;
import com.gomai.spring_boot.persistence.UserDataPersistence;

/**
 * 
 * 〈用户单元测试类〉
 *
 * @author Administrator
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

	@Autowired
	private UserDataPersistence userDataPersistence;

	@Test
	public void testInsert() {
		int result = 0;
		UserData userData = new UserData("001", "张三", "zhangsan", new Date(), "this is remark!");

		result = this.userDataPersistence.insert(userData);
		System.out.println(result);
	}

//	@Test
//	public void testGet() {
//		UserData user = this.userDataPersistence.getUser("001");
//		System.out.println(user);
//	}

/*	@Test
	public void testUpdate() {
		UserData userData = new UserData();
		userData.setId("001");
		userData.setPassword("lisi001");
		this.userDataPersistence.update(userData);
	}

	@Test
	public void testDelete() {
		int result = this.userDataPersistence.deleteById("001");
		System.out.println(result);
	}*/
}
