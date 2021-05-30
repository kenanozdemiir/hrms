package com.hrms.hrms.business.abstracts;

import java.util.List;

import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Employer;

public interface EmployerService {
	
	List<Employer> getAll();
	
	Result add(String mail,String password,
		    String repeatPassword,String companyName,
		    String webAdress,String phone);

}
