package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.EmployerService;
import com.hrms.hrms.core.concretes.EmailManager;
import com.hrms.hrms.core.utilities.check.EmployerCheckHelper;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.dataAccess.abstracts.EmployerDao;
import com.hrms.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}
	
	
	@Override
	public List<Employer> getAll() {
		
		return employerDao.findAll();
	}

	@Override
	public Result add(Employer newEmployer) {
		if(EmployerCheckHelper.isEmpty(newEmployer))
			return new ErrorResult("Bilgiler boş bırakılamaz.");
		if(!EmployerCheckHelper.isCompany(newEmployer))
			return new ErrorResult("Bu mail bir şirket hesabına ait değil.");
		if(EmployerCheckHelper.isPasswordSame(newEmployer)==false)
			return new ErrorResult("Şifreler aynı olmalıdır.");
		if(!EmailManager.confirmEmployerEmail(newEmployer))
			return new ErrorResult("Bu mail adresi doğrulanmamış");
		if(employerDao.existsByMail(newEmployer.getMail()))
			return new ErrorResult("Bu mail sistemde zaten kayıtlı.");
		
	this.employerDao.save(newEmployer);
	return new SuccessDataResult<Employer>(this.employerDao.save(newEmployer), "Kayıt başarılı.");
	}

	

}
