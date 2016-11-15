package com.kidd.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kidd.core.domain.JsonResult;
import com.kidd.core.domain.JsonResult.ResultEnum;
import com.kidd.core.domain.User;
import com.kidd.core.service.UserService;

/**
 * 用户信息控制层
 * @author kidd
 * @since 2016-11-15 11:30
 */

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/getUser")
	@ResponseBody
	public JsonResult getUser(Long id){
		User user = userService.getUserById(id);
		return new JsonResult(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), user);
	}
}
