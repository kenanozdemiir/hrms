package com.hrms.hrms.business.abstracts;

import java.util.List;


import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Language;
import com.hrms.hrms.entities.dtos.LanguageAddDto;

public interface LanguageService {
	Result add(LanguageAddDto languageAddDto);
	DataResult<List<Language>> getAll();
}
