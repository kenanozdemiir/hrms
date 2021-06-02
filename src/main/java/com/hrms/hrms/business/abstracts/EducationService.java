package com.hrms.hrms.business.abstracts;

import java.util.List;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Education;

public interface EducationService {
	Result add(Education newEducation);
	DataResult<List<Education>> getAll();
	List<Education> findAllByOrderByEndDateDesc();
}
