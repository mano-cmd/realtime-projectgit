package com.bg.service;

import java.util.List;

import com.bg.model.PersonDetailsModel;

public interface SSARegistrationService {
	
	public List<String> getAllStates();
	
	public String savePersonDetails(PersonDetailsModel personModel);
}
