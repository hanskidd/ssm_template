package com.kidd.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidd.core.dao.UserMapper;
import com.kidd.core.domain.User;
import com.kidd.core.service.UserService;
/**
 * 用户业务层
 * @author kidd
 * @since 2016-11-15 10:45
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User getUserById(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}

}
