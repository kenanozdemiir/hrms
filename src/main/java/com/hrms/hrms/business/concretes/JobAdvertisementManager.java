package com.hrms.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
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
import com.hrms.hrms.entities.dtos.JobAdvertisementsAddDto;
import com.hrms.hrms.entities.dtos.JobAdvertisementsDto;


@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	
	private JobAdvertisementDao jobAdvertisementDao;
	private ModelMapper modelMapper;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao,ModelMapper modelMapper) {
		this.jobAdvertisementDao = jobAdvertisementDao;	
		this.modelMapper = modelMapper;
	}

	private List<JobAdvertisementsDto> dtoListConverter (List<JobAdvertisement> jobAdvertisement){
		List<JobAdvertisementsDto> jobAdDto = new ArrayList<JobAdvertisementsDto>();
		jobAdvertisement.forEach(x -> {
			JobAdvertisementsDto dto = modelMapper.map(x, JobAdvertisementsDto.class);
			dto.setCompanyName(x.getEmployer().getCompanyName());
			dto.setJobPosition(x.getJobPosition().getPosition());
			jobAdDto.add(dto);
		});
		return jobAdDto;
	}
	
	private JobAdvertisement dtoClassConverter (JobAdvertisementsAddDto jobAdvertisementsAddDto){
		
		JobAdvertisement jobAd = modelMapper.map(jobAdvertisementsAddDto, JobAdvertisement.class);
		jobAdvertisementsAddDto.setEmployerId(jobAd.getEmployer().getId());
		jobAdvertisementsAddDto.setJobPositionId(jobAd.getJobPosition().getId());
		jobAdvertisementsAddDto.setCityId(jobAd.getCity().getId());
		
		
		return jobAd;
	}
	
	
	
	
	@Override
	public List<JobAdvertisementsDto> getAll() {
		return this.dtoListConverter(this.jobAdvertisementDao.findByStatus(true));
	}

	@Override
	public Result add(JobAdvertisementsAddDto newJobAdvertisementsAddDto) {	
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.save(this.dtoClassConverter(newJobAdvertisementsAddDto)), "Başarıyla kaydedildi.");
	}

	@Override
	public DataResult<List<JobAdvertisementsDto>> findAllByOrderByStartingDateAsc() {
		return new SuccessDataResult<List<JobAdvertisementsDto>>(this.dtoListConverter(this.jobAdvertisementDao.findByStatusOrderByStartingDateAsc(true)),"Tarihe göre artan şekilde sıralandı.") ;	
	}

	@Override
	public List<JobAdvertisementsDto> getByCompanyName(String companyName) {
		return this.dtoListConverter(this.jobAdvertisementDao.findByStatusAndEmployer_CompanyName(true, companyName));
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
