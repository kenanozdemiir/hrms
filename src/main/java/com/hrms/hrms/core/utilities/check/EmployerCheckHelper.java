package com.hrms.hrms.core.utilities.check;

import com.hrms.hrms.entities.concretes.Employer;

public class EmployerCheckHelper {
	
	public static boolean emptyCheck(Employer employer) {
		if(employer.getCompany_name().isEmpty()||
				employer.getMail().isEmpty()||
				employer.getWeb_adress().isEmpty()||
				employer.getPassword().isEmpty()||
				employer.getPhone().isEmpty())
			return false;
		else
			return true;
	}
	
	public static boolean domainCheck(Employer employer) {
		if(!employer.getMail().contains(employer.getCompany_name()))
			return false;
		else 
			return true;
	}

}
