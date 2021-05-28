package com.hrms.hrms.core.utilities.check;

import com.hrms.hrms.entities.concretes.Candidate;
import com.hrms.hrms.entities.concretes.Employer;

public class EmployerCheckHelper {
	
	public static boolean isEmpty(Employer employer) {
		if(employer.getCompany_name().isEmpty()||
				employer.getMail().isEmpty()||
				employer.getWeb_adress().isEmpty()||
				employer.getPassword().isEmpty()||
				employer.getPhone().isEmpty())
			return true;
		else
			return false;
	}
	
	public static boolean isCompany(Employer employer) {
		if(employer.getMail().contains(employer.getCompany_name()))
			return true;
		else 
			return false;
	}
	
	public static boolean isPasswordSame(Employer employer) {
		
		if(employer.getPassword().equals(employer.getRepeatPassword())) 
			return true;
		else
			return false;
	}
}
