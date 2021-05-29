package com.hrms.hrms.core.abstracts;

import com.hrms.hrms.entities.concretes.Candidate;

public interface CandidateCheckHelper {
	
	public boolean isCandidateEmpty(Candidate candidate);
	
	public boolean isPasswordSame(Candidate candidate);

}
