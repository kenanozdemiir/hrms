package com.hrms.hrms.core.abstracts;

import org.springframework.web.multipart.MultipartFile;

import com.hrms.hrms.core.utilities.results.DataResult;

public interface CloudinaryService {
	DataResult<?> save(MultipartFile file);

}
