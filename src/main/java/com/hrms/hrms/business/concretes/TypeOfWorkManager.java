package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.TypeOfWorkService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.dataAccess.abstracts.TypeOfWorkDao;
import com.hrms.hrms.entities.concretes.TypeOfWork;

@Service
public class TypeOfWorkManager implements TypeOfWorkService {
	
	private TypeOfWorkDao typeOfWorkDao;
	
	@Autowired
	public TypeOfWorkManager(TypeOfWorkDao typeOfWorkDao) {
		super();
		this.typeOfWorkDao = typeOfWorkDao;
	}
	@Override
	public DataResult<List<TypeOfWork>> getAll() {
		return new SuccessDataResult<List<TypeOfWork>>(typeOfWorkDao.findAll());
	}

}
