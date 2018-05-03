package com.vany.utils;

import com.vany.common.CodeEnum;
import com.vany.entity.Result;

/**
 * 封装返回结果工具
 * @author van元
 *
 */
public class ResultUtil {
	
	/**
	 * 操作成功,默认用户未登录
	 * @param t 结果对象
	 * @return 
	 */
	public static <T> Result<T> success(){
		return success(false);
	}
	
	/**
	 * 操作成功，设置用户登录状态
	 * @param userToken
	 * @return
	 */
	public static <T> Result<T> success(Boolean userToken){
		Result<T> result =new Result<>(); 
		result.setUserToken(userToken);
		result.setCode(CodeEnum.SUCCESS.getCode());
		result.setMsg(CodeEnum.SUCCESS.getMsg());
		return result;
	}
	
	/**
	 * 操作成功,默认用户未登录
	 * @param data
	 * @return
	 */
	public static <T> Result<T> success(T data){
		return success(data, false);
	}
	
	/**
	 * 操作成功，设置用户登录状态
	 * @param data
	 * @param userToken
	 * @return
	 */
	public static <T> Result<T> success(T data,Boolean userToken){
		Result<T> result =new Result<>(); 
		result.setUserToken(userToken);
		result.setCode(CodeEnum.SUCCESS.getCode());
		result.setMsg(CodeEnum.SUCCESS.getMsg());
		result.setData(data);
		return result;
	}
	
	/**
	 * 系统未知错误，默认用户未登录
	 * @return
	 */
	public static <T> Result<T>	error(){
		Result<T> result =new Result<>(); 
		result.setUserToken(false);
		result.setCode(CodeEnum.UNKNOWN.getCode());
		result.setMsg(CodeEnum.UNKNOWN.getMsg());
		return result;
	}
	/**
	 * 自定义错误信息，默认用户未登录
	 * @param CodeEnum	错误信息和代码
	 * @return
	 */
	public static <T> Result<T>	error(CodeEnum codeEnum){
		Result<T> result =new Result<>(); 
		result.setUserToken(false);
		result.setCode(codeEnum.getCode());
		result.setMsg(codeEnum.getMsg());
		return result;
	}
	/**
	 * 自定义错误信息
	 * @param codeEnum
	 * @param userToken
	 * @return
	 */
	public static <T> Result<T>	error(CodeEnum codeEnum,Boolean userToken){
		Result<T> result =new Result<>(); 
		result.setUserToken(userToken);
		result.setCode(codeEnum.getCode());
		result.setMsg(codeEnum.getMsg());
		return result;
	}
}
