package com.hrms.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.CandidateService;
import com.hrms.hrms.business.abstracts.VerificationCodeService;
import com.hrms.hrms.core.abstracts.CandidateCheckHelper;
import com.hrms.hrms.core.abstracts.MernisService;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.CandidateDao;
import com.hrms.hrms.dataAccess.abstracts.CvDao;
import com.hrms.hrms.entities.concretes.Candidate;
import com.hrms.hrms.entities.dtos.CandidateCvDto;
 



@Service
public class CandidateManager implements CandidateService{
	
	private CandidateDao candidateDao;
	private VerificationCodeService verificationCodeService;
	private MernisService mernisService;
	private CandidateCheckHelper candidateCheckHelper;
	
	

	@Autowired
	public CandidateManager(CandidateDao candidateDao,MernisService mernisService,CandidateCheckHelper candidateCheckHelper, VerificationCodeService verificationCodeService,CvDao cvDao) {
		super();
		this.candidateDao = candidateDao;
		this.verificationCodeService = verificationCodeService;
		this.mernisService = mernisService;
		this.candidateCheckHelper = candidateCheckHelper;
	}
	
	@Override
	public List<Candidate> getAll(){
		
		return candidateDao.findAll();
		
	}

	@Override
	public Result add(Candidate newCandidate){
		if(candidateCheckHelper.isCandidateEmpty(newCandidate))
			return new ErrorResult("Tüm alanları doldurunuz.");		
		if(candidateCheckHelper.isPasswordSame(newCandidate)==false)
			return new ErrorResult("Şifreler aynı olmalıdır.");
		if(mernisService.confirm(newCandidate.getNationalIdentity(), newCandidate.getName(), newCandidate.getSurname(), newCandidate.getBirthYear())==false)
			return new ErrorResult("Mernis Doğrulaması başarısız.");
		if(candidateDao.existsByNationalIdentity(newCandidate.getNationalIdentity()))
			return new ErrorResult("Bu kimlik numarasına sahip kullanıcı zaten mevcut.");
		if(candidateDao.existsByMail(newCandidate.getMail()))
			return new ErrorResult("Bu mail sistemde zaten kayıtlı.");
		
	
		candidateDao.save(newCandidate);
		verificationCodeService.createVerificationCode(newCandidate);

		return new SuccessResult("Kayıt başarılı.");	
	}
	
	public CandidateCvDto getCandidateCvAllById(int id){
		return this.candidateDao.getCandidateCvAllById(id);
	}

	
	
	
	
		
		
	

}
