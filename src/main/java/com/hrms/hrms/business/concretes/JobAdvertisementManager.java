package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.JobAdvertisementService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.hrms.hrms.entities.concretes.JobAdvertisement;
import com.hrms.hrms.entities.dtos.JobAdvertisementsDto;


@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	
	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;	
	}

	@Override
	public List<JobAdvertisementsDto> getAll() {
		return this.jobAdvertisementDao.getByActive();
	}

	@Override
	public Result add(JobAdvertisement newJobAdvertisement) {	
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.save(newJobAdvertisement), "Başarıyla kaydedildi.");
	}

	@Override
	public DataResult<List<JobAdvertisementsDto>> findAllByOrderByStartingDateAsc() {
		return new SuccessDataResult<List<JobAdvertisementsDto>>(this.jobAdvertisementDao.findAllByOrderByStartingDateAsc(),"Tarihe göre artan şekilde sıralandı.") ;	
	}

	@Override
	public List<JobAdvertisementsDto> getByCompanyName(String companyName) {
		return this.jobAdvertisementDao.getByCompanyNamewithDto(companyName);
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
