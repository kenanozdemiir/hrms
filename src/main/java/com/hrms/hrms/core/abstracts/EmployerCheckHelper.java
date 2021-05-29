package com.hrms.hrms.core.abstracts;

import com.hrms.hrms.entities.concretes.Employer;

public interface EmployerCheckHelper {
	public boolean isEmpty(Employer employer);
	public boolean isCompany(Employer employer);
	public boolean isPasswordSame(Employer employer);

}
