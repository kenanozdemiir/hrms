package com.hrms.hrms.core.utilities.email;

import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessResult;

public class EmailManager implements EmailService {

	@Override
	public Result sendEmail(String name, String mail) {
		
		return new SuccessResult("Email " + name + "kullanıcısına gönderildi");
	}

}
