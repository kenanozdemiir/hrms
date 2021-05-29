package com.hrms.hrms.business.abstracts;

import java.util.List;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.User;
import com.hrms.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {
	
	DataResult<List<VerificationCode>> getAll();
	
	public VerificationCode findByVerifyCode(String code);
	
	public void createVerificationCode(User user);
	
	public Result verifyUser(String verifyCode, int userId);

}
