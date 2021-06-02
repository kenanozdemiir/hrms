package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.CvService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.dataAccess.abstracts.CvDao;
import com.hrms.hrms.entities.concretes.Cv;

@Service
public class CvManager implements CvService {
	
	private CvDao cvDao;
	
	@Autowired
	public CvManager(CvDao cvDao) {
		super();
		this.cvDao = cvDao;
	}

	@Override
	public Result add(Cv newCv) {
		this.cvDao.save(newCv);
		return new SuccessDataResult<Cv>(this.cvDao.save(newCv), "Başarıyla eklendi.");
	}
	
	@Override
	public DataResult<List<Cv>> getAll(){
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll(), "Cv'ler başarıyla listelendi.");
	}

}
