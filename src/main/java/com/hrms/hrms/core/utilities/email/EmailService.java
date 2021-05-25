package com.hrms.hrms.core.utilities.email;

import com.hrms.hrms.core.utilities.results.Result;

public interface EmailService {
	
	Result sendEmail(String name,String mail);

}
