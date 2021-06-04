package com.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.business.abstracts.EducationService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Education;
import com.hrms.hrms.entities.dtos.EducationAddDto;

@RestController
@RequestMapping("/api/education")
public class EducationController {
	private EducationService educationService;

	@Autowired
	public EducationController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<EducationAddDto>> getAll(){
		return educationService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody EducationAddDto educationAddDto) {
		return this.educationService.add(educationAddDto);
		
	}
	
	@GetMapping("findAllByOrderByEndDateDesc")
	public List<Education> findAllByOrderByEndDateDesc(){
		return this.educationService.findAllByOrderByEndDateDesc();
	}
	
	
}
