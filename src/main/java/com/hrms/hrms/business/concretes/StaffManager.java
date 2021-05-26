package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.StaffService;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.StaffDao;
import com.hrms.hrms.entities.concretes.Staff;

@Service
public class StaffManager implements StaffService {
	
	private StaffDao staffDao;
	
	@Autowired
	public StaffManager(StaffDao staffDao) {
		super();
		this.staffDao = staffDao;
	}
	
	public List<Staff> getAll(){
		return staffDao.findAll();
	}

	@Override
	public Result add(Staff newStaff) {
		staffDao.save(newStaff);
		return new SuccessResult("Başarıyla eklendi.");
	}
	

}
