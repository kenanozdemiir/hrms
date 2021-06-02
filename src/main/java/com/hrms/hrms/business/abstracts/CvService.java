package com.hrms.hrms.business.abstracts;

import java.util.List;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Cv;

public interface CvService {
	Result add(Cv cv);
	DataResult<List<Cv>> getAll();
}