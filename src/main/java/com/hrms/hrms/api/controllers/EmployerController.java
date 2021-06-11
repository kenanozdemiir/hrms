package com.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.business.abstracts.EmployerService;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employer")
@CrossOrigin

public class EmployerController {
	
	private EmployerService employerService;
	
	public EmployerController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getall")
	public List<Employer> getAll() {
		
		return employerService.getAll();
		
	}
	
	@PostMapping("/add")
	
	public Result add(@RequestBody Employer newEmployer) {
		
		return employerService.add(newEmployer);
		
	}
	
	
	
	

}
