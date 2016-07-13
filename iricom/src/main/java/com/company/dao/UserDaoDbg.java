package com.company.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.company.model.DbgAuthority;
import com.company.model.UserVo;
@Repository
public class UserDaoDbg implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select count(*) from DBG_USER_TB", Integer.class);
	}

	@Override
	public int insert(UserVo userVo) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("insert into DBG_USER_TB (user_id, user_name, email, password, address, postcode, created_date, last_date) values(?,?,?,?,?,?,now(),now())",
				userVo.getUserId(), userVo.getUserName(), userVo.getEmail(), userVo.getPassword(), userVo.getAddress(), userVo.getPostcode());
		
	}

	@Override
	public int update(UserVo userVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateDate(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserVo selectOne(String userId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select * from DBG_USER_TB where user_id = ?", new RowMapper<UserVo>() {
		@Override
		public UserVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			UserVo userVo = new UserVo();
			userVo.setNumber(rs.getInt("no"));
			userVo.setUserId(rs.getString("user_id"));
			userVo.setUserName(rs.getString("user_name"));
			userVo.setEmail(rs.getString("email"));
			userVo.setPassword(rs.getString("password"));
			userVo.setAddress(rs.getString("address"));
			userVo.setPostcode(rs.getInt("postcode"));
			userVo.setCreatedDate(rs.getTimestamp("created_date"));
			userVo.setLastDate(rs.getTimestamp("last_date"));
			userVo.setAuthority(DbgAuthority.valueOf(rs.getInt("authority")));
			return userVo;
		}
		},userId);
	}

}
