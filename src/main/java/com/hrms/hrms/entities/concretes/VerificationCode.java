package com.hrms.hrms.entities.concretes;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="verify_code")


public class VerificationCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
	@Column(name= "verify_code")
	private String verifyCode;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	
	@Column(name="created_date")
	private LocalDateTime createdDate;
	
	@Column(name="confirmed_date")
	private LocalDateTime confirmedDate;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="is_staff_confirmed")
	private boolean isStaffConfirmed;
	
	@Column(name="confirming_staff_id")
	private int confirmingStaffId;
	
	

}
