package com.hrms.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrms.hrms.business.abstracts.TechnologyService;
import com.hrms.hrms.core.dtoConverter.ConvertService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.dataAccess.abstracts.TechnologyDao;
import com.hrms.hrms.entities.concretes.Technology;
import com.hrms.hrms.entities.dtos.TechnologyAddDto;

@Service
public class TechnologyManager implements TechnologyService{

	private TechnologyDao technologyDao;
	private ConvertService convertService;

	@Autowired
	public TechnologyManager(TechnologyDao technologyDao,ConvertService convertService) {
		super();
		this.technologyDao = technologyDao;
		this.convertService = convertService;
	
	}
	
	
	@Override
	public Result add(TechnologyAddDto technologyAddDto) {
		
		return new SuccessDataResult<Technology>(this.technologyDao.save((Technology)this.convertService.dtoClassConverter(technologyAddDto, Technology.class)), "Başarıyla eklendi.");
	}
	
	@Override
	public DataResult<List<TechnologyAddDto>> getAll(){
		return new SuccessDataResult<List<TechnologyAddDto>>(this.convertService.dtoConverter(this.technologyDao.findAll(), TechnologyAddDto.class), "Cv'ler başarıyla listelendi.");
	}
	
}
