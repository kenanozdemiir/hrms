package com.hrms.hrms.business.abstracts;

import java.util.List;

import com.hrms.hrms.entities.concretes.Employer;

public interface EmployerService {
	
	List<Employer> getAll();
	
	Employer add(Employer newEmployer);

}
