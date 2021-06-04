package com.hrms.hrms.core.concretes;
import org.springframework.stereotype.Service;

import com.hrms.hrms.core.abstracts.CheckHelper;

@Service
public class CheckManager implements CheckHelper{
	

	
	
	public boolean isCompany(String mail,String companyName) {
		if(mail.substring(mail.indexOf('@')+1,mail.indexOf('.')).equals(companyName.toLowerCase()))
			return true;
		else 
			return false;
	}
	
	public boolean isPasswordSame(String password,String repeatPassword) {
		
		if(password.equals(repeatPassword)) 
			return true;
		else
			return false;
	}
}
