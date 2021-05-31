package com.hrms.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementsDto {
	
	private String companyName;
	private String jobPosition;
	private int quato;
	private Date startingDate;
	private Date endDate;
	
	

}
