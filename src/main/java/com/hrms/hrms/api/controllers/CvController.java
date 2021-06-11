package com.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.hrms.business.abstracts.CvService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Cv;
import com.hrms.hrms.entities.dtos.CvAddDto;

@RestController
@RequestMapping("/api/cvs")
@CrossOrigin
public class CvController {
	private CvService cvService;
	
	@Autowired
	public CvController(CvService cvService) {
		super();
		this.cvService = cvService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Cv>> getAll() {
		return this.cvService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvAddDto newCvAddDto) {
		return this.cvService.add(newCvAddDto);
	}
	
	@PutMapping("/uploadImage")
	public Result saveImage(@RequestBody MultipartFile file,@RequestParam int cvId) {
		return this.cvService.saveImage(file, cvId);
		
	}
}
