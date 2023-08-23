package com.example.demo.response;

import org.springframework.http.HttpStatus;

public class EmployeeResponse<T> {

	private T Data;

	private String msg;

	private HttpStatus httpStatus;

	public EmployeeResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeResponse(T data, String msg, HttpStatus httpStatus) {
		super();
		Data = data;
		this.msg = msg;
		this.httpStatus = httpStatus;
	}

	public T getData() {
		return Data;
	}

	public void setData(T data) {
		Data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	@Override
	public String toString() {
		return "EmployeeResponse [Data=" + Data + ", msg=" + msg + ", httpStatus=" + httpStatus + "]";
	}

}
