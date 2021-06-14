package com.hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.hrms.entities.concretes.WorkTime;

public interface WorkTimeDao extends JpaRepository<WorkTime, Integer> {

}
