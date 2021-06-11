package com.hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.hrms.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer> {
	List<Education> findAllBycvIdOrderByEndDateDesc(int id);
}
