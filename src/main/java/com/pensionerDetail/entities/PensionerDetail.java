package com.pensionerDetail.entities;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PensionerDetail {

	private Pensioner pensioner;
	private Bankdetail bankdetail;

}
