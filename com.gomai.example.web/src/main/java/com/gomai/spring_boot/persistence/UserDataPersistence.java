package com.gomai.spring_boot.persistence;

import com.gomai.spring_boot.data.UserData;

public interface UserDataPersistence {
	
	/**
	 * 
	 *〈添加用户信息〉<br>
	 * 
	 * @author weinan <br> 
	 *		   2018年9月14日
	 * @update 
	 * @return  int
	 * @since [1.0.0]
	 */
	public int insert(UserData userData);
	
	/**
	 * 
	 *〈删除用户信息根据id〉<br>
	 * 
	 * @author weinan <br> 
	 *		   2018年9月14日
	 * @update 
	 * @param [参数1]     [参数1说明]
	 * @return  int
	 * @since [1.0.0]
	 */
	public int deleteById(String id);
	
	/**
	 * 
	 *〈更新用户信息根据id〉<br>
	 * 
	 * @author weinan <br> 
	 *		   2018年9月14日
	 * @update 
	 * @param [参数1]     [参数1说明]
	 * @return  int
	 * @since [1.0.0]
	 */
	public int update(UserData userData);
	
	/**
	 * 
	 *〈获取用户信息根据id〉<br>
	 * 
	 * @author Administrator <br> 
	 *		   2018年9月14日
	 * @update 
	 * @param [参数1]     [参数1说明]
	 * @return  UserData
	 * @since [1.0.0]
	 */
	public UserData getUser(String id);
}
