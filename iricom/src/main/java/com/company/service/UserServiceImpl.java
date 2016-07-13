package com.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.UserDao;
import com.company.model.UserVo;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDaoDbg;
	@Override
	public int insertUser(UserVo userVo) {
		// TODO Auto-generated method stub
		return userDaoDbg.insert(userVo);
	}
	public UserVo selectOneUser(String userId){
		// TODO Auto-generated method stub
		return userDaoDbg.selectOne(userId);
	}

}
