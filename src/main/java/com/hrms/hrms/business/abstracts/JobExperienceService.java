package com.hrms.hrms.business.abstracts;

import java.util.List;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobExperience;
import com.hrms.hrms.entities.dtos.JobExperienceAddDto;

public interface JobExperienceService {
	Result add(JobExperienceAddDto newJobExperienceAddDto);
	DataResult<List<JobExperience>> getAll();
	List<JobExperience> findAllByOrderByEndDateDesc();
}
