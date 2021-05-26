package com.hrms.hrms.core.utilities.check;

import com.hrms.hrms.entities.concretes.Candidate;

public class CandidateCheckHelper {
	
	public static boolean emptyCheck(Candidate candidate) {
		if(candidate.getName().isEmpty()|| candidate.getBirth_year().isEmpty()
			|| candidate.getBirth_year().isEmpty() || candidate.getMail().isEmpty()
			|| candidate.getSurname().isEmpty() || candidate.getPassword().isEmpty())
			return false;
		else
			return true;
		
	}

}
