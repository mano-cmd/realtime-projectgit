package com.bg.exceptions;

public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -9161026360573675679L;
	
	public DataNotFoundException() {
		super();
	}
	
	public DataNotFoundException(String msg) {
		super(msg);
	}

}
