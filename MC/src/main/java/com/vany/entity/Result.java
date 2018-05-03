package com.vany.entity;
/**
 * 统一响应结果信息
 * @author van元
 *
 * @param <T>
 */
public class Result<T> {
	
	private Boolean userToken;	//登录标识
	
	private Integer code;	//状态码
	
	private String msg;		//响应消息
		
	private T data;			//结果对象

	public Boolean getUserToken() {
		return userToken;
	}

	public void setUserToken(Boolean userToken) {
		this.userToken = userToken;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Result [userToken=" + userToken + ", code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}


}
