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
@Table(name = "BANKDETAIL_DB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bankdetail {
	@Id
	private Long aadhaar_number;
	@Column(name = "BANK_NAME")
	private String bank_name;
	@Column(name = "ACCOUNT_NO")
	private String account_number;
	@Column(name = "BANK_TYPE")
	private String publicOrprivate_bank;

}
