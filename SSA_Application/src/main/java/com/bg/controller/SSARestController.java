package com.bg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bg.exceptions.DataNotFoundException;
import com.bg.service.SSAStateIdFinderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api("This Rest Controller Finds StateCode For Corresponding SSN Number")
public class SSARestController {
	
	@Autowired
	private SSAStateIdFinderService ssaService;
	
	@GetMapping(value="/getStateCode/{ssnNo}",produces = { "application/json"})
	@ApiOperation(value = "This Method Returns StateCode For Given SSN Number")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Success"),
		@ApiResponse(code = 400,message = "BadRequest"),
		@ApiResponse(code = 500, message = "Server Problem") 
	})
	public ResponseEntity<String> getStateCode(@ApiParam("SSN Number" ) @PathVariable("ssnNo") Long ssnNumber){
		String stateCode=ssaService.getStateCode(ssnNumber);
		
		if(stateCode==null)
			throw new DataNotFoundException("Invalid SSN Number");
		return new ResponseEntity<String>(stateCode,HttpStatus.OK);
	}
}
