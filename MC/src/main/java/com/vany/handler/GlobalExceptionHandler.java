package com.vany.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vany.common.CodeEnum;
import com.vany.entity.Result;
import com.vany.exception.GlobalException;
import com.vany.utils.ResultUtil;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	
	@ExceptionHandler
	@ResponseBody
	public Result<?> handle(Exception e) {
		if(e instanceof GlobalException) {
			GlobalException te =(GlobalException) e;
			logger.error("这是自定义异常：{}",te.getMsg());
			return ResultUtil.error(CodeEnum.TOPIC_ERROR);
		}
		
		logger.error("【系统异常】:{}",e);
		return ResultUtil.error();
	}
	

}
