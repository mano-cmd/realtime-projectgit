package com.bg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bg.entity.StateEntity;

@Repository
public interface StatesRepository extends JpaRepository<StateEntity, Integer>{

	@Query(value = "SELECT stateName FROM StateEntity")
	public List<String> findAllStates();
	
	@Query(value = "SELECT stateCode FROM StateEntity WHERE stateName=:sName")
	public String findStateCode(String sName);
	
}
