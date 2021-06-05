package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrms.hrms.business.abstracts.LanguageService;
import com.hrms.hrms.core.dtoConverter.ConvertService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.dataAccess.abstracts.LanguageDao;
import com.hrms.hrms.entities.concretes.Language;
import com.hrms.hrms.entities.dtos.LanguageAddDto;

@Service
public class LanguageManager implements LanguageService {
	
	private LanguageDao languageDao;
	private ConvertService convertService;
	@Autowired
	public LanguageManager(LanguageDao languageDao,ConvertService convertService) {
		super();
		this.languageDao = languageDao;
		this.convertService = convertService;
		
	}
	

	@Override
	public Result add(LanguageAddDto languageAddDto) {
		return new SuccessDataResult<Language>(this.languageDao.save((Language)this.convertService.dtoClassConverter(languageAddDto,Language.class)), "Başarıyla eklendi.");
	}

	@Override
	public DataResult<List<LanguageAddDto>> getAll() {
		return new SuccessDataResult<List<LanguageAddDto>>(this.convertService.dtoConverter(languageDao.findAll(),LanguageAddDto.class), "Cv'ler başarıyla listelendi.");
	}

}
