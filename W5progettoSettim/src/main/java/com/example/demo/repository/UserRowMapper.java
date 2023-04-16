package com.example.demo.repository;

import java.sql.ResultSet;


import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.User;

public class UserRowMapper implements RowMapper<User>  {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getLong("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		return user;
	}
}
