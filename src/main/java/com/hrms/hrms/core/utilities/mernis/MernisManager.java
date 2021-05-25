package com.hrms.hrms.core.utilities.mernis;

import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessResult;

public class MernisManager implements MernisService {

	@Override
	public Result confirm(String identityNumber, String firstName, String lastName, String birthYear) {
		
		return new SuccessResult("Mernis Doğrulaması başarılı.");
	}

}
