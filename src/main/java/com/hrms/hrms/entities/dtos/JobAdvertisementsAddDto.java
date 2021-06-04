package com.hrms.hrms.entities.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementsAddDto {
	@JsonIgnore
	private int id;
	
	private int employerId;
	private int jobPositionId;
	private int cityId;
	private int quato;
	private int minSalary;
	private int maxSalary;
	private LocalDateTime startingDate;
	private LocalDateTime endDate;
	private String description;
	

}
