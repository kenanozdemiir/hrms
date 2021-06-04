package com.hrms.hrms.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.JobExperienceService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.dataAccess.abstracts.JobExperienceDao;
import com.hrms.hrms.entities.concretes.JobExperience;
import com.hrms.hrms.entities.dtos.JobExperienceAddDto;

@Service
public class JobExperienceManager implements JobExperienceService{
	private JobExperienceDao jobExperienceDao;
	private ModelMapper modelMapper;
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao,ModelMapper modelMapper) {
		super();
		this.jobExperienceDao = jobExperienceDao;
		this.modelMapper = modelMapper;
	}
	
private JobExperience dtoClassConverter (JobExperienceAddDto jobExperienceAddDto){
		
		JobExperience jobExperience = modelMapper.map(jobExperienceAddDto, JobExperience.class);
		jobExperienceAddDto.setCvId(jobExperience.getCv().getId());
		jobExperienceAddDto.setJobPositionId(jobExperience.getJobPosition().getId());
		
		return jobExperience;
	}

	@Override
	public Result add(JobExperienceAddDto newJobExperienceAddDto) {
		return new SuccessDataResult<JobExperience>(jobExperienceDao.save(this.dtoClassConverter(newJobExperienceAddDto)), "Başarıyla eklendi.");
	}

	@Override
	public DataResult<List<JobExperience>> getAll() {
		return new SuccessDataResult<List<JobExperience>>(jobExperienceDao.findAll(), "Başarıyla listelendi.");
	}

	@Override
	public List<JobExperience> findAllByOrderByEndDateDesc() {
		return jobExperienceDao.findAllByOrderByEndDateDesc();
	}

}
