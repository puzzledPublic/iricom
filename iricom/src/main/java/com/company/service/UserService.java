package com.company.service;

import com.company.model.UserVo;

public interface UserService {
	public int insertUser(UserVo userVo);
	public UserVo selectOneUser(String userId);
	public boolean selectOneBool(String userId);
}
