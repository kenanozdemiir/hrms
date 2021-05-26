package com.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hrms.hrms.business.abstracts.StaffService;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Staff;

@RestController
@RequestMapping("/api/staff")

public class StaffController {
	
	private StaffService staffService;
	
	@Autowired
	public StaffController(StaffService staffService) {
		super();
		this.staffService = staffService;
	}
	
	@GetMapping("/getall")
	public List<Staff> getAll(){
		return staffService.getAll();
	}
	
	@PostMapping("/add")
	
	public Result add(@RequestBody Staff newStaff) {
		return staffService.add(newStaff);
	}

}