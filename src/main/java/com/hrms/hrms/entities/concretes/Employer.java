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
@Table(name = "employer_users")

public class Employer extends User {
	
	
	
	@Column(name = "company_name")
	private String company_name;
	
	
	@Column(name = "web_adress")
	private String web_adress;
	
	@Column(name = "phone")
	private String phone;
	
	
}
