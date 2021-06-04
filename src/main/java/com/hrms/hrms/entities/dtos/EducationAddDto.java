package com.hrms.hrms.entities.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationAddDto {
	
	@JsonIgnore
	private int id;
	
	private int cvId;
	
	private String schoolName;
	
	private int graduateId;
	
	private String department;
	
	private LocalDateTime startingDate;
	
	private LocalDateTime endDate;

}
