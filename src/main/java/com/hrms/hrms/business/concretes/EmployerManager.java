package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.EmployerService;
import com.hrms.hrms.core.abstracts.EmailService;
import com.hrms.hrms.core.abstracts.EmployerCheckHelper;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.dataAccess.abstracts.EmployerDao;
import com.hrms.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private EmailService emailService;
	private EmployerCheckHelper employerCheckHelper;
	
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,EmailService emailService,EmployerCheckHelper employerCheckHelper) {
		super();
		this.employerDao = employerDao;
		this.emailService = emailService;
		this.employerCheckHelper = employerCheckHelper;
	}
	
	
	@Override
	public List<Employer> getAll() {
		
		return employerDao.findAll();
	}

	@Override
	public Result add(Employer newEmployer) {
		if(employerCheckHelper.isEmpty(newEmployer))
			return new ErrorResult("Bilgiler boş bırakılamaz.");
		if(!employerCheckHelper.isCompany(newEmployer))
			return new ErrorResult("Bu mail bir şirket hesabına ait değil.");
		if(employerCheckHelper.isPasswordSame(newEmployer)==false)
			return new ErrorResult("Şifreler aynı olmalıdır.");
		if(!emailService.confirmEmployerEmail(newEmployer))
			return new ErrorResult("Bu mail adresi doğrulanmamış");
		if(employerDao.existsByMail(newEmployer.getMail()))
			return new ErrorResult("Bu mail sistemde zaten kayıtlı.");
		
	this.employerDao.save(newEmployer);
	return new SuccessDataResult<Employer>(this.employerDao.save(newEmployer), "Kayıt başarılı.");
	}

	

}
