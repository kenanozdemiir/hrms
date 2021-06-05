package com.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.business.abstracts.TechnologyService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.dtos.TechnologyAddDto;

@RestController
@RequestMapping("/api/technology")
public class TechnologyController {
	private TechnologyService technologyService;

	@Autowired
	public TechnologyController(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<TechnologyAddDto>> getAll() {
		return this.technologyService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody TechnologyAddDto technologyAddDto) {
		return this.technologyService.add(technologyAddDto);
	}
}
