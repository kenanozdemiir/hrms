package com.hrms.hrms.core.abstracts;



public interface CheckHelper {
	public boolean isEmpty(String mail,String password,
		    String repeatPassword,String companyName,
		    String webAdress,String phone);
	public boolean isCompany(String mail,String companyName);
	public boolean isPasswordSame(String password,String repeatPassword);

}
