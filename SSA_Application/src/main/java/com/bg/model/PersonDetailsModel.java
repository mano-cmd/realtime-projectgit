package com.bg.model;







import java.util.Date;

import lombok.Data;

@Data
public class PersonDetailsModel {
	
	private String firstName;
	private String lastName;
	private Date dob;
	private String gender;
	private String state;
	
}
