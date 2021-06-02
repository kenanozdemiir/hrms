package com.hrms.hrms.entities.dtos;

import java.util.List;

import com.hrms.hrms.entities.concretes.Cv;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateCvDto {
	
	private String name;
	private String surname;
	private Cv cv;

}
