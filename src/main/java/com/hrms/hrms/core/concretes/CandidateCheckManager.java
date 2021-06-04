package com.hrms.hrms.core.concretes;

import org.springframework.stereotype.Service;

import com.hrms.hrms.core.abstracts.CandidateCheckHelper;
import com.hrms.hrms.entities.concretes.Candidate;

@Service
public class CandidateCheckManager implements CandidateCheckHelper{
	
	
	public boolean isPasswordSame(Candidate candidate) {
		
		if(candidate.getPassword().equals(candidate.getRepeatPassword())) 
			return true;
		else
			return false;
			
		
	
	}
}
