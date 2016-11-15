package com.kidd.core.service;

import com.kidd.core.domain.User;

public interface UserService {

	/**
	 * 通过id获取用户信息
	 * @param id
	 * @return
	 */
	public User getUserById(Long id);
}
