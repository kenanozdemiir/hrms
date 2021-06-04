package com.hrms.hrms.core.abstracts;

import com.hrms.hrms.entities.concretes.Candidate;

public interface CandidateCheckHelper {
	
	
	public boolean isPasswordSame(Candidate candidate);

}
