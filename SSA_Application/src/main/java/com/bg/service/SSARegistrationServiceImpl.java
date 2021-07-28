package com.bg.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bg.entity.PersonDetailsEntity;
import com.bg.model.PersonDetailsModel;
import com.bg.repository.PersonDetailsRepository;
import com.bg.repository.StatesRepository;

@Service
public class SSARegistrationServiceImpl implements SSARegistrationService{

	@Autowired
	private StatesRepository stateRepo;
	
	@Autowired
	private PersonDetailsRepository personRepo;

	@Override
	public List<String> getAllStates() {
		return stateRepo.findAllStates();
	}

	@Override
	public String savePersonDetails(PersonDetailsModel personModel) {
		
		PersonDetailsEntity personEntity=new PersonDetailsEntity();
		BeanUtils.copyProperties(personModel, personEntity);
		personEntity.setState(stateRepo.findStateCode(personModel.getState()));
		PersonDetailsEntity savedEntity = personRepo.save(personEntity);
		
		if(savedEntity!=null)
			return String.valueOf(savedEntity.getSsaNumber()).replaceFirst("(\\d{3})(\\d{2})(\\d{4})", "$1-$2-$3");
		return null;
	}
}
