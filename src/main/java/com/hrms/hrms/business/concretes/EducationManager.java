package com.hrms.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrms.hrms.business.abstracts.EducationService;
import com.hrms.hrms.core.dtoConverter.ConvertService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.dataAccess.abstracts.EducationDao;
import com.hrms.hrms.entities.concretes.Education;
import com.hrms.hrms.entities.dtos.EducationAddDto;

@Service
public class EducationManager implements EducationService {
	
	private EducationDao educationDao;
	private ConvertService convertService;
	
	@Autowired
	public EducationManager(EducationDao educationDao,ConvertService convertService) {
		super();
		this.educationDao = educationDao;
		this.convertService = convertService;
	}


	@Override
	public Result add(EducationAddDto educationAddDto) {
		return new SuccessDataResult<Education>(this.educationDao.save((Education)convertService.dtoClassConverter(educationAddDto, Education.class)), "Başarıyla eklendi.");
	}

	@Override
	public DataResult<List<EducationAddDto>> getAll() {
		return new SuccessDataResult<List<EducationAddDto>>(this.convertService.dtoConverter(this.educationDao.findAll(), EducationAddDto.class), "Başarıyla listelendi.");
	}

	@Override
	public List<Education> findAllBycvIdOrderByEndDateDesc(int id) {
		return this.educationDao.findAllBycvIdOrderByEndDateDesc(id);
	}

}
