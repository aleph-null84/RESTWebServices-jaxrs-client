package com.yuriy.traning.messenger.exception;

public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6561760886275981792L;
	
	public DataNotFoundException(String message){
		super(message);
	}

}
