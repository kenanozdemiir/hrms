package com.hrms.hrms.core.response;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hrms.hrms.entities.concretes.JobAdvertisement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Service
public class Response {
	
	
	String companyName;
	String jobPosition;
	int quato;
	Date startingDate;
	Date endDate;
	
	public List<Response> match(List<JobAdvertisement> listJobAd){
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

}
