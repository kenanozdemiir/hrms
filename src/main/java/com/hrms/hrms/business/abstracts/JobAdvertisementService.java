package com.hrms.hrms.business.abstracts;

import java.util.List;


import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.dtos.JobAdvertisementsAddDto;
import com.hrms.hrms.entities.dtos.JobAdvertisementsDto;

public interface JobAdvertisementService {
	
	public List<JobAdvertisementsDto> getAll();
	
	public Result add(JobAdvertisementsAddDto jobAdvertisementsAddDto);
	
	public DataResult<List<JobAdvertisementsDto>> findAllByOrderByStartingDateAsc();
	
	public List<JobAdvertisementsDto> getByCompanyName(String companyName);
	
	public Result closeAd(int id,int employerId);
	
	
}
