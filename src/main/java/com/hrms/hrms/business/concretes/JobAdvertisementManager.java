package com.hrms.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.JobAdvertisementService;
import com.hrms.hrms.core.response.Response;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.hrms.hrms.entities.concretes.JobAdvertisement;


@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	
	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;
		
	}

	@Override
	public List<Response> getAll() {
		List<JobAdvertisement> listJobAd = this.jobAdvertisementDao.getByActive();
		List<Response> listResponse = new ArrayList<Response>();
		for(JobAdvertisement jobAds:listJobAd) {
			Response response = new Response();
			response.setCompanyName(jobAds.getEmployer().getCompany_name());
			response.setJobPosition(jobAds.getJobPosition().getPosition());
			response.setQuato(jobAds.getQuato());
			response.setStartingDate(jobAds.getStartingDate());
			response.setEndDate(jobAds.getEndDate());
			listResponse.add(response);
			}
		return listResponse;
	}

	@Override
	public Result add(JobAdvertisement newJobAdvertisement) {
		
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.save(newJobAdvertisement), "Başarıyla kaydedildi.");
	}

	@Override
	public List<Response> getAllByDateAsc() {
		Sort sort = Sort.by(Sort.Direction.ASC,"startingDate");
		List<JobAdvertisement> listJobAd = this.jobAdvertisementDao.findAll(sort);
		List<Response> listResponse = new ArrayList<Response>();
		for(JobAdvertisement jobAds:listJobAd) {
			Response response = new Response();
			response.setCompanyName(jobAds.getEmployer().getCompany_name());
			response.setJobPosition(jobAds.getJobPosition().getPosition());
			response.setQuato(jobAds.getQuato());
			response.setStartingDate(jobAds.getStartingDate());
			response.setEndDate(jobAds.getEndDate());
			listResponse.add(response);
			}
		return listResponse;
		
		
	}

	@Override
	public List<Response> getByCompanyName(String companyName) {
		List<JobAdvertisement> listJobAd = this.jobAdvertisementDao.getByCompanyName(companyName);
		List<Response> listResponse = new ArrayList<Response>();
		for(JobAdvertisement jobAds:listJobAd) {
			Response response = new Response();
			response.setCompanyName(jobAds.getEmployer().getCompany_name());
			response.setJobPosition(jobAds.getJobPosition().getPosition());
			response.setQuato(jobAds.getQuato());
			response.setStartingDate(jobAds.getStartingDate());
			response.setEndDate(jobAds.getEndDate());
			listResponse.add(response);
			}
		return listResponse;
	}

	@Override
	public Result closeAd(int id, int employerId) {
		if(this.jobAdvertisementDao.existsByEmployer_id(employerId)) {
		JobAdvertisement jbRecor = this.jobAdvertisementDao.findById(id);
		jbRecor.setStatus(false);
		this.jobAdvertisementDao.save(jbRecor);
		return new SuccessResult("İlan kapatıldı.");
		}
		else
			return new ErrorResult("Böyle bir employer yok.");
		
		
		
	}
	
}
