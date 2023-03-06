package com.bloggingApp.exceptions;

public class ApiResp {

	private String message;
	
	private boolean status;

//...........................................................
	
	public ApiResp(String message, boolean status) {
		super();
		this.message = message;
		this.status = status;
	}

//............................................................	
	public ApiResp() {
		super();
		// TODO Auto-generated constructor stub
	}
//............................................................	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	
	
}
