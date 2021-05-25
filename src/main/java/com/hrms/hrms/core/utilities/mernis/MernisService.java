package com.hrms.hrms.core.utilities.mernis;

import com.hrms.hrms.core.utilities.results.Result;

public interface MernisService {
	Result confirm(String identityNumber,String firstName,String lastName,String birthYear);

}
