package com.hrms.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hrms.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
		
		@Query("From JobAdvertisement where status=true" )
		List<JobAdvertisement> getByActive();
		
		@Override
		@Query("From JobAdvertisement where status=true")
		List<JobAdvertisement> findAll(Sort sort);
		
		//List<JobAdvertisement> getAllActiveSortedDateDesc();
		
		@Query("From JobAdvertisement where employer.company_name=:companyName and status=true")
		List<JobAdvertisement> getByCompanyName(String companyName);
		
		JobAdvertisement findById(int id);
		
		boolean existsByEmployer_id(int id);
		
}
