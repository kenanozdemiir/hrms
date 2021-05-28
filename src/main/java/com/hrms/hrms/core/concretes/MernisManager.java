package com.hrms.hrms.core.concretes;




public class MernisManager {

	public static boolean confirm(String identityNumber, String firstName, String lastName, String birthYear) {
		
		if(identityNumber.length()==11 && firstName.length()>2 && lastName.length()>2 && birthYear.length()==4)
			return true;
		else
			return false;
	}

}
