package com.hrms.hrms.core.abstracts;

import com.hrms.hrms.entities.concretes.Candidate;

public interface EmailService {
	
	boolean confirmCandidateEmail(Candidate candidate);

}
