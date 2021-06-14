package com.hrms.hrms.business.abstracts;

import java.util.List;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.entities.concretes.TypeOfWork;

public interface TypeOfWorkService {
	
	DataResult<List<TypeOfWork>> getAll();

}
