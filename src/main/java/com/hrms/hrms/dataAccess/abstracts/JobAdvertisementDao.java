package com.hrms.hrms.dataAccess.abstracts;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.hrms.hrms.entities.concretes.JobAdvertisement;
import com.hrms.hrms.entities.dtos.JobAdvertisementsDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
		
		@Query("Select new com.hrms.hrms.entities.dtos.JobAdvertisementsDto(e.companyName,j.position,ad.quato,ad.startingDate,ad.endDate)"
				+ " From Employer e,JobPosition j Inner Join e.jobAdvertisements ad where status=true")
		List<JobAdvertisementsDto> getByActive();
		
	
		@Query("Select new com.hrms.hrms.entities.dtos.JobAdvertisementsDto(e.companyName,j.position,ad.quato,ad.startingDate,ad.endDate)"
				+ " From Employer e,JobPosition j Inner Join e.jobAdvertisements ad where status=true order by ad.startingDate")
		List<JobAdvertisementsDto> findAllByOrderByStartingDateAsc();
		
		@Query("Select new com.hrms.hrms.entities.dtos.JobAdvertisementsDto(e.companyName,j.position,ad.quato,ad.startingDate,ad.endDate)"
				+ "From Employer e,JobPosition j Inner Join e.jobAdvertisements ad where status=true and e.companyName=:companyName")
		List<JobAdvertisementsDto> getByCompanyNamewithDto(String companyName);
		
		JobAdvertisement findById(int id);
		
		boolean existsByEmployer_id(int id);
		
}
