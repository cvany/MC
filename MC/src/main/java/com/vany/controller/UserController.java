package com.vany.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vany.entity.Result;
import com.vany.utils.ResultUtil;
/**
 * 用户控制类，返回JSON数据
 * @author van元
 *
 */
@RestController
public class UserController {
	
	@GetMapping("user")
	public Result<?> getUser(){
		return ResultUtil.success();
	}

}
