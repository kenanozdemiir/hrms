package com.hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "candidate_users")

public class Candidate extends User {
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "identity_number")
	private String national_identity;
	
	@Column(name = "birth_year")
	private String birth_year;
	
	@Column(name = "verify")
	private boolean verify;

}
