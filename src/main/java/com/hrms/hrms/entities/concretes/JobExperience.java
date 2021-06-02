package com.hrms.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cvs_job_exp")
public class JobExperience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = Cv.class)
	@JoinColumn(name="cv_id")
	private Cv cv;
	
	@NotBlank
	@Column(name="company_name")
	private String companyName;
	
	
	@ManyToOne(targetEntity =JobPosition.class, fetch = FetchType.LAZY)
	@JoinColumn(name="job_position_id",referencedColumnName = "id", nullable = false)
	private JobPosition jobPosition;
	
	@NotBlank
	@Column(name="starting_date")
	private LocalDateTime startingDate;
	
	@Column(name="end_date")
	private LocalDateTime endDate;
	
}
