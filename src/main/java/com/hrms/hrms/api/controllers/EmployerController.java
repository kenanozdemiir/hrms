package com.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.business.abstracts.EmployerService;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employer")

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
	
	public Result add(@RequestParam (name="Mail") String mail,
			@RequestParam(name="Şifre") String password,
			@RequestParam(name="Şifre tekrarı") String repeatPassword,
			@RequestParam(name="Şirket Adı") String companyName,
			@RequestParam(name="Web Adresi") String webAdress,
			@RequestParam(name="Telefon numarası") String phone) {
		
		return employerService.add(mail,password,repeatPassword,companyName,webAdress,phone);
		
	}
	
	
	
	

}
