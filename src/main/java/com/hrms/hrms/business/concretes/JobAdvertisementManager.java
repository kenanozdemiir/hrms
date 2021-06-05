package com.hrms.hrms.business.concretes;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrms.hrms.business.abstracts.JobAdvertisementService;
import com.hrms.hrms.core.dtoConverter.ConvertService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.hrms.hrms.entities.concretes.JobAdvertisement;
import com.hrms.hrms.entities.dtos.JobAdvertisementsAddDto;
import com.hrms.hrms.entities.dtos.JobAdvertisementsDto;


@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	
	private JobAdvertisementDao jobAdvertisementDao;
	private ConvertService convertService;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao,ConvertService convertService) {
		this.jobAdvertisementDao = jobAdvertisementDao;	
		this.convertService = convertService;
	}

	
	
	
	
	
	@Override
	public List<JobAdvertisementsDto> getAll() {
		return this.convertService.dtoConverter(this.jobAdvertisementDao.findByStatus(true),JobAdvertisementsDto.class);
	}

	@Override
	public Result add(JobAdvertisementsAddDto newJobAdvertisementsAddDto) {	
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.save((JobAdvertisement)convertService.dtoClassConverter(newJobAdvertisementsAddDto,JobAdvertisement.class)), "Başarıyla kaydedildi.");
	}

	@Override
	public DataResult<List<JobAdvertisementsDto>> findAllByOrderByStartingDateAsc() {
		return new SuccessDataResult<List<JobAdvertisementsDto>>(this.convertService.dtoConverter(this.jobAdvertisementDao.findByStatusOrderByStartingDateAsc(true),JobAdvertisementsDto.class),"Tarihe göre artan şekilde sıralandı.") ;	
	}

	@Override
	public List<JobAdvertisementsDto> getByCompanyName(String companyName) {
		return this.convertService.dtoConverter(this.jobAdvertisementDao.findByStatusAndEmployer_CompanyName(true, companyName),JobAdvertisementsDto.class);
	}

	@Override
	public Result closeAd(int id, int employerId) {
		if(this.jobAdvertisementDao.existsByEmployer_id(employerId)) {
		JobAdvertisement jbRecor = this.jobAdvertisementDao.findById(id);
		jbRecor.setStatus(false);
		this.jobAdvertisementDao.save(jbRecor);
			return new SuccessResult("İlan kapatıldı.");
		}
		else
			return new ErrorResult("Böyle bir employer yok.");	
	}	
}
