package com.hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.hrms.entities.concretes.Cv;

public interface CvDao extends JpaRepository<Cv, Integer>{

}
