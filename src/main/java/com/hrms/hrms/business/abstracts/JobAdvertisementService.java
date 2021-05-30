package com.hrms.hrms.business.abstracts;

import java.util.List;



import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	public List<JobAdvertisement> getAll();
	
	public Result add(JobAdvertisement newJobAdvertisement);
	
	public List<JobAdvertisement> getAllByDateAsc();
	
	public List<JobAdvertisement> getByCompanyName(String companyName);
	
	public Result closeAd(int id,int employerId);
	
	
}
