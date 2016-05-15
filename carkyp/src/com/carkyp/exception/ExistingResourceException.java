package com.carkyp.exception;

public class ExistingResourceException extends Exception{
	
	
	private static final long serialVersionUID = -2166900998538784412L;
	private int errorCode;
	private String message;
	
	public ExistingResourceException(){
		
	}
	
	
	public ExistingResourceException(int errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
