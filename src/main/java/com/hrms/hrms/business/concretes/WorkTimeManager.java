package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.WorkTimeService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.dataAccess.abstracts.WorkTimeDao;
import com.hrms.hrms.entities.concretes.WorkTime;

@Service
public class WorkTimeManager implements WorkTimeService{
	private WorkTimeDao workTimeDao;
	
	@Autowired
	public WorkTimeManager(WorkTimeDao workTimeDao) {
		super();
		this.workTimeDao = workTimeDao;
	}

	@Override
	public DataResult<List<WorkTime>> getAll() {

		return new SuccessDataResult<List<WorkTime>>(workTimeDao.findAll());
	}

}
