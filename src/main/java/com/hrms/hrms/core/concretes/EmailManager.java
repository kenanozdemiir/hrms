package com.hrms.hrms.core.concretes;

import org.springframework.stereotype.Service;

import com.hrms.hrms.core.abstracts.EmailService;
import com.hrms.hrms.entities.concretes.Candidate;
import com.hrms.hrms.entities.concretes.Employer;

@Service
public class EmailManager implements EmailService {

	
	public boolean confirmCandidateEmail(Candidate candidate) {
		if(candidate.isVerify()==true)
			return true;
		else
			return false;
		
	}
	
	public boolean confirmEmployerEmail(Employer employer) {
		if(employer.isVerify()==true)
			return true;
		else
			return false;
	}

}
