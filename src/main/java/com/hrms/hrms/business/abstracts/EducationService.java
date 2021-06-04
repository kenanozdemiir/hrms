package com.hrms.hrms.business.abstracts;

import java.util.List;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Education;
import com.hrms.hrms.entities.dtos.EducationAddDto;

public interface EducationService {
	Result add(EducationAddDto educationAddDto);
	DataResult<List<EducationAddDto>> getAll();
	List<Education> findAllByOrderByEndDateDesc();
}
