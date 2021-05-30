package com.hrms.hrms.core.response;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Response {
	
	
	String companyName;
	String jobPosition;
	int quato;
	Date startingDate;
	Date endDate;
	
	
	

}
