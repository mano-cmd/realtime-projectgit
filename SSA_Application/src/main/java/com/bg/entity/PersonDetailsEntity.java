package com.bg.entity;






import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "SSA_PERSON_DETAILS")
public class PersonDetailsEntity {

	@Id
	@Column(name = "SSA_NUMBER", length = 9)
	@Type(type = "long")
	@SequenceGenerator(name = "SSA_SEQ", sequenceName = "SSA_NO_SEQ", initialValue = 100000000, allocationSize = 1)
	@GeneratedValue(generator = "SSA_SEQ")
	private Long ssaNumber;

	@Column(name = "FIRST_NAME", length = 20)
	@Type(type = "string")
	private String firstName;

	@Column(name = "LASST_NAME", length = 20)
	@Type(type = "string")
	private String lastName;

	@Column(name = "DOB" )
	@Type(type = "date")
	 @DateTimeFormat(pattern="dd-mm-yyyy")
	private Date dob;

	@Column(name = "GENDER", length = 7)
	@Type(type = "string")
	private String gender;

	@Column(name = "STATE", length = 20)
	@Type(type = "string")
	private String state;

}
