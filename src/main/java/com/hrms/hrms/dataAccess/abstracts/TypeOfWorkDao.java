package com.hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.hrms.entities.concretes.TypeOfWork;

public interface TypeOfWorkDao extends JpaRepository<TypeOfWork, Integer> {

}
