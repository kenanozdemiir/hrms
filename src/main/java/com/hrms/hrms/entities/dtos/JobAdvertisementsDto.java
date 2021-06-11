package com.hrms.hrms.entities.dtos;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementsDto {
	
	private int id;
	private String EmployerCompanyName;
	private String jobPositionPosition;
	private int quato;
	private LocalDateTime startingDate;
	private LocalDateTime endDate;
	private int minSalary;
	private int maxSalary;
	
	

}
