package com.company.dao;

import org.springframework.transaction.annotation.Transactional;

import com.company.model.UserVo;

public interface UserDao {

	public int count();
	public int insert(UserVo userVo);
	public int update(UserVo userVo);
	public int delete(String userId);
	public int updateDate(String userId);
	public UserVo selectOne(String userId);
	
}
