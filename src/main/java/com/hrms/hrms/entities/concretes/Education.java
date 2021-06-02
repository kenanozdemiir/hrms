package com.hrms.hrms.entities.concretes;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cvs_edu")


public class Education {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = Cv.class)
	@JoinColumn(name="cv_id")
	private Cv cv;
	
	@NotBlank
	@Column(name="school_name")
	private String schoolName;
	

	@ManyToOne(targetEntity = Graduate.class)
	@JoinColumn(name="graduate_id",referencedColumnName = "id", nullable = false)
	private Graduate graduate;
	
	@NotBlank
	@Column(name="department")
	private String department;
	
	
	@Column(name="starting_date")
	private LocalDateTime startingDate;   //@temporal o anki saati otomatik yazar.jparepositoryden çöz.
	
	@Column(name="end_date")
	private LocalDateTime endDate;
}
