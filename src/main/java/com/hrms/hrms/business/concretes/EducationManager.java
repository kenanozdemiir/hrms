package com.hrms.hrms.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrms.hrms.business.abstracts.EducationService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.dataAccess.abstracts.EducationDao;
import com.hrms.hrms.entities.concretes.Education;
import com.hrms.hrms.entities.dtos.EducationAddDto;

@Service
public class EducationManager implements EducationService {
	
	private EducationDao educationDao;
	private ModelMapper modelMapper;
	
	@Autowired
	public EducationManager(EducationDao educationDao,ModelMapper modelMapper) {
		super();
		this.educationDao = educationDao;
		this.modelMapper = modelMapper;
	}
	
	private Education dtoClassConverter (EducationAddDto educationAddDto){
		
		Education education = modelMapper.map(educationAddDto, Education.class);
		educationAddDto.setCvId(education.getCv().getId());
		educationAddDto.setGraduateId(education.getId());
		
		return education;
	}

	@Override
	public Result add(EducationAddDto educationAddDto) {
		return new SuccessDataResult<Education>(educationDao.save(this.dtoClassConverter(educationAddDto)), "Başarıyla eklendi.");
	}

	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<List<Education>>(educationDao.findAll(), "Başarıyla listelendi.");
	}

	@Override
	public List<Education> findAllByOrderByEndDateDesc() {
		return this.educationDao.findAllByOrderByEndDateDesc();
	}

}
