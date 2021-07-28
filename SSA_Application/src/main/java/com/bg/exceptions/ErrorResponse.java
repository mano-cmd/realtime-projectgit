package com.bg.exceptions;

import lombok.Data;

@Data
public class ErrorResponse {
	
	private String errorCode;
	private String errorDesc;
	
}
