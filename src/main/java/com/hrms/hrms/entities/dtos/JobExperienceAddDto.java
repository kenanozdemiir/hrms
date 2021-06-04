package com.hrms.hrms.entities.dtos;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobExperienceAddDto {
	@JsonIgnore
	private int id;
	
	private int cvId;
	private String companyName;
	private int jobPositionId;
	private LocalDateTime startingDate;
	private LocalDateTime endDate;
	
}
