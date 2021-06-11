package com.hrms.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})

public class Employer extends User {
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "web_adress")
	private String webAdress;
	
	@Column(name = "phone")
	private String phone;
	
	@JsonIgnore
	@OneToMany(mappedBy= "employer")
	private List<JobAdvertisement> jobAdvertisements;
}
