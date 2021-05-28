package com.hrms.hrms.core.concretes;



import com.hrms.hrms.entities.concretes.Candidate;

public class EmailManager {

	
	public static boolean confirmEmail(Candidate candidate) {
		if(candidate.isVerify()==true)
			return true;
		else
			return false;
		
	}

}
