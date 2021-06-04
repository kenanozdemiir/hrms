package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.EmployerService;
import com.hrms.hrms.business.abstracts.VerificationCodeService;
import com.hrms.hrms.core.abstracts.CheckHelper;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.dataAccess.abstracts.EmployerDao;
import com.hrms.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private CheckHelper checkHelper;
	private VerificationCodeService verificationCodeService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,CheckHelper checkHelper,VerificationCodeService verificationCodeService) {
		super();
		this.employerDao = employerDao;
		this.checkHelper = checkHelper;
		this.verificationCodeService = verificationCodeService;
	}
	
	
	@Override
	public List<Employer> getAll() {
		
		return employerDao.findAll();
	}

	@Override
	public Result add(Employer newEmployer) {
		
		if(employerDao.existsByMail(newEmployer.getMail()))
			return new ErrorResult("Bu mail sistemde zaten kayıtlı.");
		if(!checkHelper.isCompany(newEmployer.getMail(),newEmployer.getCompanyName()))
			return new ErrorResult("Bu mail bir şirket hesabına ait değil.");
		if(checkHelper.isPasswordSame(newEmployer.getPassword(),newEmployer.getRepeatPassword())==false)
			return new ErrorResult("Şifreler aynı olmalıdır.");
		
		
		employerDao.save(newEmployer);
		verificationCodeService.createVerificationCode(newEmployer);
	return new SuccessDataResult<Employer>(this.employerDao.save(newEmployer), "Kayıt başarılı.");
	}

	

}
