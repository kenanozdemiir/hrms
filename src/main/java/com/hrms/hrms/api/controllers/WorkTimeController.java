package com.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.business.abstracts.WorkTimeService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.entities.concretes.WorkTime;

@RestController
@RequestMapping("api/worktimes")
public class WorkTimeController {
	
	private WorkTimeService workTimeService;

	@Autowired
	public WorkTimeController(WorkTimeService workTimeService) {
		super();
		this.workTimeService = workTimeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<WorkTime>> getAll(){
		return this.workTimeService.getAll();
	}
	

}
