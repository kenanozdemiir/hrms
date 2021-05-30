package com.hrms.hrms.core.concretes;
import org.springframework.stereotype.Service;

import com.hrms.hrms.core.abstracts.CheckHelper;

@Service
public class CheckManager implements CheckHelper{
	
	public boolean isEmpty(String mail,String password,
		    String repeatPassword,String companyName,
		    String webAdress,String phone) {
		if(mail.isEmpty()||
				password.isEmpty()||
				webAdress.isEmpty()||
				phone.isEmpty()||
				companyName.isEmpty()||
				repeatPassword.isEmpty())
			return true;
		else
			return false;
	}
	
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
