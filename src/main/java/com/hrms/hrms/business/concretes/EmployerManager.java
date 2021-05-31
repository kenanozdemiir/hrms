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
	public Result add(String mail,String password,
		    String repeatPassword,String companyName,
		    String webAdress,String phone) {
		if(checkHelper.isEmpty(mail,password,repeatPassword,companyName,webAdress,phone))
			return new ErrorResult("Bilgiler boş bırakılamaz.");
		if(employerDao.existsByMail(mail))
			return new ErrorResult("Bu mail sistemde zaten kayıtlı.");
		if(!checkHelper.isCompany(mail,companyName))
			return new ErrorResult("Bu mail bir şirket hesabına ait değil.");
		if(checkHelper.isPasswordSame(password,repeatPassword)==false)
			return new ErrorResult("Şifreler aynı olmalıdır.");
		

		Employer newEmployer = new Employer();		
		newEmployer.setMail(mail);
		newEmployer.setPassword(password);
		newEmployer.setRepeatPassword(repeatPassword);
		newEmployer.setCompanyName(companyName);
		newEmployer.setWeb_adress(webAdress);
		newEmployer.setPhone(phone);
		
		
		employerDao.save(newEmployer);
		verificationCodeService.createVerificationCode(newEmployer);
	return new SuccessDataResult<Employer>(this.employerDao.save(newEmployer), "Kayıt başarılı.");
	}

	

}
