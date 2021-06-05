package com.hrms.hrms.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.JobExperienceService;
import com.hrms.hrms.core.dtoConverter.ConvertService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.dataAccess.abstracts.JobExperienceDao;
import com.hrms.hrms.entities.concretes.JobExperience;
import com.hrms.hrms.entities.dtos.JobExperienceAddDto;

@Service
public class JobExperienceManager implements JobExperienceService{
	private JobExperienceDao jobExperienceDao;
	private ConvertService convertService;
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao,ModelMapper modelMapper,ConvertService convertService) {
		super();
		this.jobExperienceDao = jobExperienceDao;
		this.convertService=convertService;
	}
	


	@Override
	public Result add(JobExperienceAddDto newJobExperienceAddDto) {
		return new SuccessDataResult<JobExperience>(jobExperienceDao.save((JobExperience)this.convertService.dtoClassConverter(newJobExperienceAddDto,JobExperience.class)), "Başarıyla eklendi.");
	}

	@Override
	public DataResult<List<JobExperience>> getAll() {
		return new SuccessDataResult<List<JobExperience>>(this.convertService.dtoConverter(this.jobExperienceDao.findAll(), JobExperience.class), "Başarıyla listelendi.");
	}

	@Override
	public List<JobExperience> findAllByOrderByEndDateDesc() {
		return jobExperienceDao.findAllByOrderByEndDateDesc();
	}

}
