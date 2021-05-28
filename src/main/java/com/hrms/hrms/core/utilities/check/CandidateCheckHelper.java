package com.hrms.hrms.core.utilities.check;

import com.hrms.hrms.entities.concretes.Candidate;

public class CandidateCheckHelper {
	
	public static boolean isCandidateEmpty(Candidate candidate) {
		if(candidate.getName().isEmpty()|| candidate.getBirthYear().isEmpty()
			|| candidate.getBirthYear().isEmpty() || candidate.getMail().isEmpty()
			|| candidate.getSurname().isEmpty() || candidate.getPassword().isEmpty())
			return true;
		else
			return false;
		
	}
	
	public static boolean isPasswordSame(Candidate candidate) {
		
		if(candidate.getPassword().equals(candidate.getRepeatPassword())) 
			return true;
		else
			return false;
			
		
	
	}
}
