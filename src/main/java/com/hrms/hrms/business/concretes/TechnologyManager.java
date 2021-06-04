package com.hrms.hrms.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.TechnologyService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.dataAccess.abstracts.TechnologyDao;
import com.hrms.hrms.entities.concretes.Technology;
import com.hrms.hrms.entities.dtos.TechnologyAddDto;

@Service
public class TechnologyManager implements TechnologyService{

	private TechnologyDao technologyDao;
	private ModelMapper modelMapper;

	@Autowired
	public TechnologyManager(TechnologyDao technologyDao,ModelMapper modelMapper) {
		super();
		this.technologyDao = technologyDao;
		this.modelMapper = modelMapper;
	}
	
	private Technology dtoClassConverter (TechnologyAddDto technologyAddDto){
		
		Technology technology = modelMapper.map(technologyAddDto, Technology.class);
		technologyAddDto.setCvId(technology.getCv().getId());
		
		
		
		return technology;
	}
	
	@Override
	public Result add(TechnologyAddDto technologyAddDto) {
		
		return new SuccessDataResult<Technology>(this.technologyDao.save(this.dtoClassConverter(technologyAddDto)), "Başarıyla eklendi.");
	}
	
	@Override
	public DataResult<List<Technology>> getAll(){
		return new SuccessDataResult<List<Technology>>(this.technologyDao.findAll(), "Cv'ler başarıyla listelendi.");
	}
	
}
