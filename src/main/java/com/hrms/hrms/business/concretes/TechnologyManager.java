package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.TechnologyService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.dataAccess.abstracts.TechnologyDao;
import com.hrms.hrms.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService{

	private TechnologyDao technologyDao;

	@Autowired
	public TechnologyManager(TechnologyDao technologyDao) {
		super();
		this.technologyDao = technologyDao;
	}
	
	@Override
	public Result add(Technology newTechnology) {
		this.technologyDao.save(newTechnology);
		return new SuccessDataResult<Technology>(this.technologyDao.save(newTechnology), "Başarıyla eklendi.");
	}
	
	@Override
	public DataResult<List<Technology>> getAll(){
		return new SuccessDataResult<List<Technology>>(this.technologyDao.findAll(), "Cv'ler başarıyla listelendi.");
	}
	
}
