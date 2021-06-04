package com.hrms.hrms.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.LanguageService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.dataAccess.abstracts.LanguageDao;
import com.hrms.hrms.entities.concretes.Language;
import com.hrms.hrms.entities.dtos.LanguageAddDto;

@Service
public class LanguageManager implements LanguageService {
	
	private LanguageDao languageDao;
	private ModelMapper modelMapper;
	@Autowired
	public LanguageManager(LanguageDao languageDao,ModelMapper modelMapper) {
		super();
		this.languageDao = languageDao;
		this.modelMapper = modelMapper;
	}
	
private Language dtoClassConverter (LanguageAddDto languageAddDto){
		
		Language language = modelMapper.map(languageAddDto, Language.class);
		languageAddDto.setCvId(language.getCv().getId());
		
		return language;
	}
	@Override
	public Result add(LanguageAddDto languageAddDto) {
		return new SuccessDataResult<Language>(this.languageDao.save(this.dtoClassConverter(languageAddDto)), "Başarıyla eklendi.");
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll(), "Cv'ler başarıyla listelendi.");
	}

}
