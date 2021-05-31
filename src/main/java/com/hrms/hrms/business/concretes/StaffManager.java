package com.hrms.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.StaffService;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.StaffDao;
import com.hrms.hrms.dataAccess.abstracts.VerificationCodeDao;
import com.hrms.hrms.entities.concretes.Staff;
import com.hrms.hrms.entities.concretes.VerificationCode;

@Service
public class StaffManager implements StaffService {
	
	private StaffDao staffDao;
	private VerificationCodeDao verificationCodeDao;
	
	@Autowired
	public StaffManager(StaffDao staffDao,VerificationCodeDao verificationCodeDao) {
		super();
		this.staffDao = staffDao;
		this.verificationCodeDao = verificationCodeDao;
	}
	
	public List<Staff> getAll(){
		return staffDao.findAll();
	}

	@Override
	public Result add(Staff newStaff) {
		staffDao.save(newStaff);
		return new SuccessResult("Başarıyla eklendi.");
	}

	@Override
	public Result verifyUser(int staffId, int userId) {
		VerificationCode verificationCode = verificationCodeDao.findByUserId(userId);
		verificationCode.setConfirmingStaffId(staffId);
		verificationCode.setStaffConfirmed(true);
		verificationCodeDao.save(verificationCode);	
		return new Result(true);
	}
	
	

}
