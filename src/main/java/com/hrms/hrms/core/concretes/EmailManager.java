package com.hrms.hrms.core.concretes;



import com.hrms.hrms.entities.concretes.Candidate;
import com.hrms.hrms.entities.concretes.Employer;

public class EmailManager {

	
	public static boolean confirmCandidateEmail(Candidate candidate) {
		if(candidate.isVerify()==true)
			return true;
		else
			return false;
		
	}
	
	public static boolean confirmEmployerEmail(Employer employer) {
		if(employer.isVerify()==true)
			return true;
		else
			return false;
	}

}
