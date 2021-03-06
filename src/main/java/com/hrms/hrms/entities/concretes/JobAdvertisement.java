package com.hrms.hrms.entities.concretes;





import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="job_advertisements")

public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="starting_date")
	private LocalDateTime startingDate;
	
	@Column(name="end_date")
	private LocalDateTime endDate;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;
	
	@Column(name="status")
	private boolean status;
	
	@Column(name="is_verified")
	private boolean isVerified;
	
	@ManyToOne
	@JoinColumn(name="type_of_work_id")
	private TypeOfWork typeOfWork;
	
	@ManyToOne
	@JoinColumn(name="work_time_id")
	private WorkTime workTime;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@Column(name="quota")
	private int quato;

}
