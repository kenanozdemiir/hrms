package com.hrms.hrms.api.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.business.abstracts.CandidateService;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidate")

public class CandidateController {
	
	private CandidateService candidateService;

	@Autowired
	public CandidateController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@GetMapping("/getall")
	public List<Candidate> getAll(){
		return candidateService.getAll();
	}
	
	@PostMapping("/add")
	
	public Result add(@RequestBody Candidate newCandidate){
		return candidateService.add(newCandidate);
	}
	
//	@PostMapping("/verifyUser")
//	public Result verifyUser(@RequestBody Candidate newCandidate) {
//		return candidateService.verifyUser(newCandidate);
//		
//	}
	
	
	
	

}
