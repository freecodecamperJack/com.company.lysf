package com.gomai.spring_boot.persistence.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.gomai.spring_boot.data.UserData;
import com.gomai.spring_boot.persistence.UserDataPersistence;

@Repository
public class UserDataPersistenceImpl implements UserDataPersistence {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(UserData userData) {
		String sql = "insert into s_user(id,userName,password,birthday,remark) values(?,?,?,?,?)";
		return this.jdbcTemplate.update(sql, userData.getId(), userData.getUserName(), userData.getPassword(),
				userData.getBirthday(), userData.getRemark());
	}

	@Override
	public int deleteById(String id) {
		String sql = "delete from s_user where id = ?";
		return this.jdbcTemplate.update(sql, id);
	}

	@Override
	public int update(UserData userData) {
		String sql = "update s_user u set u.password = ? where u.id = ?";
		return this.jdbcTemplate.update(sql, userData.getPassword(), userData.getId());
	}

	@Override
	public UserData getUser(String id) {
		String sql = "select u.* from s_user u where u.id = ?";
		return this.jdbcTemplate.queryForObject(sql, new RowMapper<UserData>() {

			@Override
			public UserData mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				UserData userData = new UserData(resultSet.getString("id"), resultSet.getString("userName"),
						resultSet.getString("password"), new Date(Long.parseLong(resultSet.getString("birthday"))), resultSet.getString("remark"));
				return userData;
			}

		},id);
	}
}
