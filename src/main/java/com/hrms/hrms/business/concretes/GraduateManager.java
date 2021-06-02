package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.GraduateService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.dataAccess.abstracts.GraduateDao;
import com.hrms.hrms.entities.concretes.Graduate;

@Service
public class GraduateManager implements GraduateService{
	
	private GraduateDao graduateDao;
	
	@Autowired
	public GraduateManager(GraduateDao graduateDao) {
		super();
		this.graduateDao = graduateDao;
	}

	@Override
	public DataResult<List<Graduate>> getAll() {
		
		return new SuccessDataResult<List<Graduate>>(this.graduateDao.findAll(), "Listelendi.");
	}

	@Override
	public Result add(Graduate newGraduate) {
		if(graduateDao.existsByDescription(newGraduate.getDescription())) {
			return new ErrorResult("Bu eğitim derecesi zaten kayıtlı.");
		}
		return new SuccessDataResult<Graduate>(this.graduateDao.save(newGraduate), "Başarıyla eklendi.");
	}
	
	

}
