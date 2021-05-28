package com.hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer  > {
	
	Candidate findByNationalIdentity(String nationalIdentity);
	
	boolean existsByNationalIdentity(String nationalIdentity);
	
	boolean existsByMail(String mail);
	
	
	

}
