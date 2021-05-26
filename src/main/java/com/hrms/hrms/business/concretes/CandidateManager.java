package com.hrms.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.CandidateService;
import com.hrms.hrms.core.utilities.check.CandidateCheckHelper;

import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.CandidateDao;
import com.hrms.hrms.entities.concretes.Candidate;
 



@Service
public class CandidateManager implements CandidateService{
	
	private CandidateDao candidateDao;
	
	

	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}
	
	@Override
	public List<Candidate> getAll(){
		
		return candidateDao.findAll();
		
	}

	@Override
	public Result add(Candidate newCandidate){
		if(!CandidateCheckHelper.emptyCheck(newCandidate)) {
			return new ErrorResult("Tüm alanları doldurunuz.");
		}
	candidateDao.save(newCandidate);
	return new SuccessResult("Kayıt başarılı.");


	
	}
	
	
	
		
		
	

}
