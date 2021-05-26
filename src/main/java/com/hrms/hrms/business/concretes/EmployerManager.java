package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.EmployerService;
import com.hrms.hrms.core.utilities.check.EmployerCheckHelper;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessResult;
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
		if(!EmployerCheckHelper.emptyCheck(newEmployer)||EmployerCheckHelper.domainCheck(newEmployer)) {
		employerDao.save(newEmployer);
		return new SuccessResult("Kayıt başarılı.");
		}
		else
			return new ErrorResult("Kayıt başarısız.");
	}

	

}
