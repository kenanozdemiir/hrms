package com.hrms.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Cv;
import com.hrms.hrms.entities.dtos.CvAddDto;

public interface CvService {
	public Result add(CvAddDto newCvAddDto);
	DataResult<List<Cv>> getAll();
	public Result saveImage(MultipartFile file, int cvId);
}
