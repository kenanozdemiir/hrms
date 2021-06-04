package com.hrms.hrms.entities.dtos;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CvAddDto {
	
	@JsonIgnoreProperties
	private int id;
	
	private int candidateId;
	private String image;
	private String linkedin;
	private String github;
	private String text;
	private LocalDateTime createdDate;
	
	
	
	

}
