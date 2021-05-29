package com.hrms.hrms.core.abstracts;

import com.hrms.hrms.entities.concretes.Candidate;
import com.hrms.hrms.entities.concretes.Employer;

public interface EmailService {
	
	boolean confirmCandidateEmail(Candidate candidate);

	boolean confirmEmployerEmail(Employer newEmployer);

}
