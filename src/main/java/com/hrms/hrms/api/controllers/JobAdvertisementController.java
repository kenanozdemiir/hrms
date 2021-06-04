package com.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.business.abstracts.JobAdvertisementService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.dtos.JobAdvertisementsAddDto;
import com.hrms.hrms.entities.dtos.JobAdvertisementsDto;

@RestController
@RequestMapping("/api/JobAdvertisement")
public class JobAdvertisementController {
	
	private JobAdvertisementService jobAdvertisementService;
	
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public List<JobAdvertisementsDto> getAll(){
		return jobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody  JobAdvertisementsAddDto newJobAdvertisementsAddDto) {
		return jobAdvertisementService.add(newJobAdvertisementsAddDto);
	}
	
	@GetMapping("/findAllByOrderByStartingDateAsc")
	public DataResult<List<JobAdvertisementsDto>> findAllByOrderByStartingDateAsc(){
		return jobAdvertisementService.findAllByOrderByStartingDateAsc();
	}
	
	@GetMapping("/getByCompanyName")
	public List<JobAdvertisementsDto> getByCompanyName(@RequestParam (name="Şirket İsmi") String companyName){
		
		return jobAdvertisementService.getByCompanyName(companyName);
	}
	
	@PostMapping("/closeAd")
	
	public Result closeAd(@RequestParam(name="Kapatılacak olan ilan no") int id,@RequestParam(name="Kapatacak olan Employer no") int employerId) {
		return jobAdvertisementService.closeAd(id,employerId);
	}	
}
