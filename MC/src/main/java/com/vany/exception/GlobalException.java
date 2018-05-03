package com.vany.exception;

import com.vany.common.CodeEnum;

public class GlobalException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private Integer code;
	private String msg;
	public GlobalException(Integer code, String msg) {
		super(msg);
		this.code = code;
		this.msg = msg;
	}
	public GlobalException(CodeEnum codeEnum) {
		super(codeEnum.getMsg());
		this.code =codeEnum.getCode();
		this.msg =codeEnum.getMsg();
	}
	public Integer getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	
}
