package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.JobPositionService;
import com.hrms.hrms.dataAccess.abstracts.JobPositionDao;
import com.hrms.hrms.entities.concretes.JobPosition;

@Service

public class JobPositionManager implements JobPositionService {

	
	private JobPositionDao jobPositionsDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionsDao) {
		super();
		this.jobPositionsDao = jobPositionsDao;
	}

	@Override
	public List<JobPosition> getAll() {
		// TODO Auto-generated method stub
		return this.jobPositionsDao.findAll();
	}

	@Override
	public JobPosition newJobPosition(JobPosition newJobPosition) {
		
		return jobPositionsDao.save(newJobPosition);
	}
	
	
	



}
