package com.hrms.hrms.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.CvService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.dataAccess.abstracts.CvDao;
import com.hrms.hrms.entities.concretes.Cv;
import com.hrms.hrms.entities.dtos.CvAddDto;


@Service
public class CvManager implements CvService {
	
	private CvDao cvDao;
	private ModelMapper modelMapper;
	
	@Autowired
	public CvManager(CvDao cvDao,ModelMapper modelMapper) {
		super();
		this.cvDao = cvDao;
		this.modelMapper = modelMapper;
	}
	
	private Cv dtoClassConverter (CvAddDto cvAddDto){
		
		Cv cv = modelMapper.map(cvAddDto, Cv.class);
		cvAddDto.setCandidateId(cv.getCandidate().getId());
		
		return cv;
	}
	@Override
	public Result add(CvAddDto newCvAddDto) {
		
		return new SuccessDataResult<Cv>(this.cvDao.save(this.dtoClassConverter(newCvAddDto)), "Başarıyla eklendi.");
	}
	
	@Override
	public DataResult<List<Cv>> getAll(){
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll(), "Cv'ler başarıyla listelendi.");
	}

}
