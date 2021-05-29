package com.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.business.abstracts.VerificationCodeService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.VerificationCode;

@RestController
@RequestMapping("api/verificationcodes")

public class VerificationCodeController {
	
	private VerificationCodeService verificationCodeService;
	
	@Autowired
	public VerificationCodeController(VerificationCodeService verificationCodeService) {
		this.verificationCodeService = verificationCodeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<VerificationCode>> getAll(){
		return verificationCodeService.getAll();	}
	
	@PostMapping("/verifyUser")
	public Result verifyUser(@RequestParam (name="Verification Code") String verifyCode,@RequestParam (name="User Id") int userId){
		return verificationCodeService.verifyUser(verifyCode,userId);
	}
	
	
	
}
