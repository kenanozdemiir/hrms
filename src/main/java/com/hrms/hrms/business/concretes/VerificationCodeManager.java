package com.hrms.hrms.business.concretes;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrms.hrms.business.abstracts.VerificationCodeService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.VerificationCodeDao;
import com.hrms.hrms.entities.concretes.User;
import com.hrms.hrms.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService {
	
	private VerificationCodeDao verificationCodeDao;
	
	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
	}

	@Override
	public DataResult<List<VerificationCode>> getAll() {
		
		return new SuccessDataResult<List<VerificationCode>>(this.verificationCodeDao.findAll(),"Kodlar listelendi.");
	}
	
	public VerificationCode findByVerifyCode(String code) {
		return this.verificationCodeDao.findByVerifyCode(code);
	}
	
	public void createVerificationCode(User user) {
		UUID uuid = UUID.randomUUID();

		VerificationCode verificationCode = new VerificationCode();
		
		verificationCode.setCreatedDate(LocalDateTime.now());
		verificationCode.setUserId(user.getId());
		verificationCode.setVerifyCode(uuid.toString());
		verificationCode.setConfirmed(false);
		

		verificationCodeDao.save(verificationCode);
	}
	
	public Result verifyUser(String verifyCode, int userId) {
		VerificationCode dbRecord = this.verificationCodeDao.findByUserId(userId);
		if(dbRecord.getVerifyCode().equals(verifyCode)) {
			dbRecord.setConfirmedDate(LocalDateTime.now());
			dbRecord.setConfirmed(true);
			this.verificationCodeDao.save(dbRecord);
			dbRecord.setConfirmedDate(LocalDateTime.now());
			return new SuccessResult("Kullanıcı başarıyla doğrulandı.");
		}else {
			return new ErrorResult("Kullanıcı doğrulaması başarız.");
		}
	}
	


}
