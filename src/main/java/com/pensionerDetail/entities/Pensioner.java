package com.pensionerDetail.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Table(name = "PENSIONER_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pensioner {
	
	@Id
	@Column(name = "AADHAAR_NUMBER")
	private Long aadhaar_number;
	@Column(name = "PENSIONER_NAME")
	private String name;
	@Column(name = "DOB")
	private String date_of_birth;
	@Column(name = "PAN_NO")
	private String pan;
	@Column(name = "SALARY_ERND")
	private double salaryEarned;
	@Column(name = "ALLOWANCES")
	private double allowances;
	@Column(name = "PENSION_TYPE")
	private String selfOrFamily;
	
}
