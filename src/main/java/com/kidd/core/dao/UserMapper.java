package com.kidd.core.dao;

import com.kidd.core.domain.User;

public interface UserMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(User user);

    int insertSelective(User user);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User user);
}