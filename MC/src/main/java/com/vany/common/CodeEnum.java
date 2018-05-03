package com.vany.common;

public enum CodeEnum {
	
	UNKNOWN(-1,"未知错误"),SUCCESS(200,"成功"),ERROR(100,"操作失败"),
	TOPIC_ERROR(101,"话题模块出错啦！");
	;
	
	private int code;
	private String msg;
	
	private CodeEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}

}
