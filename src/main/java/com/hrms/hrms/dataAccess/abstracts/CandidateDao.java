package com.hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.hrms.hrms.entities.concretes.Candidate;
import com.hrms.hrms.entities.dtos.CandidateCvDto;

public interface CandidateDao extends JpaRepository<Candidate, Integer  > {
	
	Candidate findByNationalIdentity(String nationalIdentity);
	
	boolean existsByNationalIdentity(String nationalIdentity);
	
	boolean existsByMail(String mail);
	
	@Query("Select new com.hrms.hrms.entities.dtos.CandidateCvDto(c.name,c.surname,cv)"
			+ " From Candidate c Inner Join c.cvs cv where cv.id=:id")
	CandidateCvDto getCandidateCvAllById(int id);
}
