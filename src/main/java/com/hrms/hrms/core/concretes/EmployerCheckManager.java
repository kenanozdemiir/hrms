package com.hrms.hrms.core.concretes;
import org.springframework.stereotype.Service;

import com.hrms.hrms.core.abstracts.EmployerCheckHelper;
import com.hrms.hrms.entities.concretes.Employer;

@Service
public class EmployerCheckManager implements EmployerCheckHelper{
	
	public boolean isEmpty(Employer employer) {
		if(employer.getCompany_name().isEmpty()||
				employer.getMail().isEmpty()||
				employer.getWeb_adress().isEmpty()||
				employer.getPassword().isEmpty()||
				employer.getPhone().isEmpty())
			return true;
		else
			return false;
	}
	
	public boolean isCompany(Employer employer) {
		if(employer.getMail().contains(employer.getCompany_name()))
			return true;
		else 
			return false;
	}
	
	public boolean isPasswordSame(Employer employer) {
		
		if(employer.getPassword().equals(employer.getRepeatPassword())) 
			return true;
		else
			return false;
	}
}
