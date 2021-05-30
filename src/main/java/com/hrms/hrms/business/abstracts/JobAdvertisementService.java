package com.hrms.hrms.business.abstracts;

import java.util.List;

import com.hrms.hrms.core.response.Response;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	public List<Response> getAll();
	
	public Result add(JobAdvertisement newJobAdvertisement);
	
	public List<Response> getAllByDateAsc();
	
	public List<Response> getByCompanyName(String companyName);
	
	public Result closeAd(int id,int employerId);
	
	
}
