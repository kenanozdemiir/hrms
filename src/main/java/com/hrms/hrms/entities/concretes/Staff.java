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
@Table(name= "staff_users")

public class Staff extends User {
	
	
	
	@Column(name = "name")
	String name;
	
	
	@Column(name= "surname")
	String surname;
}
