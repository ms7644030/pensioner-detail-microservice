package com.pensionerDetail.services;

import java.util.List;

import com.pensionerDetail.entities.PensionerDetail;

public interface PensionerDetailService {

	PensionerDetail getPensionerDetailByAadhaar(Long aadhaar, String header);

	PensionerDetail savePensionerDetail(PensionerDetail pensionerDetail, String header);

	List<PensionerDetail> getPensionersDetail(String header);
}
