package com.hrms.hrms.business.abstracts;

import java.util.List;

import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Staff;

public interface StaffService {
	
	List<Staff> getAll();
	
	Result add(Staff newStaff);
	
	Result verifyUser(int staffId, int userId);
}
