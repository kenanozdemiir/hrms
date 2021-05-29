package com.hrms.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.CandidateService;
import com.hrms.hrms.core.abstracts.CandidateCheckHelper;
import com.hrms.hrms.core.abstracts.EmailService;
import com.hrms.hrms.core.abstracts.MernisService;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.CandidateDao;
import com.hrms.hrms.entities.concretes.Candidate;
 



@Service
public class CandidateManager implements CandidateService{
	
	private CandidateDao candidateDao;
	private MernisService mernisService;
	private EmailService emailService;
	private CandidateCheckHelper candidateCheckHelper;
	
	
	
	

	@Autowired
	public CandidateManager(CandidateDao candidateDao,MernisService mernisService,EmailService emailService,CandidateCheckHelper candidateCheckHelper) {
		super();
		this.candidateDao = candidateDao;
		this.mernisService = mernisService;
		this.emailService = emailService;
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
		if(!emailService.confirmCandidateEmail(newCandidate))
			return new ErrorResult("Bu mail adresi doğrulanmamış");
		candidateDao.save(newCandidate);
		return new SuccessResult("Kayıt başarılı.");	
	


	
	}
	
	
	
		
		
	

}
