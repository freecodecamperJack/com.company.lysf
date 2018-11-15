package com.gomai.spring_boot.data;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * 〈用户 实体〉<br>
 *
 * @author Administrator
 */
public class UserData implements Serializable {

	/**
	 */
	private static final long serialVersionUID = -8373909924612452713L;

	private String id;

	private String userName;

	private String password;

//	@JSONField(format = "yyyy-MM-dd")
	private Date birthday;

	/*
	 * 如果不想返回某字段 设置serialize是否需要序列化属性
	 */
//	@JSONField(serialize = false)
	private String remark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public UserData() {
		super();
	}

	public UserData(String id, String userName, String password, Date birthday, String remark) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.birthday = birthday;
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "UserData [id=" + id + ", userName=" + userName + ", password=" + password + ", birthday=" + birthday
				+ ", remark=" + remark + "]";
	}

}
