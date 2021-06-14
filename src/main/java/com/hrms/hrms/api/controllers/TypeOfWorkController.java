package com.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.business.abstracts.TypeOfWorkService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.entities.concretes.TypeOfWork;

@RestController
@RequestMapping("api/typeofworks")
public class TypeOfWorkController {
	private TypeOfWorkService typeOfWorkService;
	
	@Autowired
	public TypeOfWorkController(TypeOfWorkService typeOfWorkService) {
		super();
		this.typeOfWorkService = typeOfWorkService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<TypeOfWork>> getAll(){
		return this.typeOfWorkService.getAll();
	}
	

}
