package com.pensionerDetail.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pensionerDetail.customException.BusinessException;
import com.pensionerDetail.entities.Bankdetail;
import com.pensionerDetail.entities.Pensioner;
import com.pensionerDetail.entities.PensionerDetail;
import com.pensionerDetail.repository.BankDetailRepo;
import com.pensionerDetail.repository.PensionerRepo;

@Service
public class PensionerDetailServiceImpl implements PensionerDetailService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${AUTHORIZATION_SERVICE_URI:http://localhost:8088}")
	private String authorizationHost;

	@Autowired
	private PensionerRepo pensionerRepository;
	@Autowired
	private BankDetailRepo bankdetailRepository;

	@Autowired
	private PensionerDetail pensionerDetail;

	@Override
	public PensionerDetail getPensionerDetailByAadhaar(Long aadhaar, String header) {

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", header);
		HttpEntity<String> request = new HttpEntity<String>(headers);

		// ResponseEntity<String> response = restTemplate
		// .getForEntity(authorizationHost + "/api/authorization-service/validate",
		// String.class);
		ResponseEntity<String> response = restTemplate.exchange(
				authorizationHost + "/api/authorization-service/validate", HttpMethod.GET, request, String.class);

		String value = (String) response.getBody();

		if (value.equalsIgnoreCase("Invalid")) {

			throw new BusinessException(400, "Invalid jwt");
		}

		else if (value.equalsIgnoreCase("valid")) {

			Pensioner pensioner = pensionerRepository.findById(aadhaar).get();
			Bankdetail bankdetail = bankdetailRepository.findById(aadhaar).get();

			pensionerDetail.setPensioner(pensioner);
			pensionerDetail.setBankdetail(bankdetail);

		}

		return pensionerDetail;

	}

	@Override
	public PensionerDetail savePensionerDetail(PensionerDetail pd, String header) {

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", header);
		HttpEntity<String> request = new HttpEntity<String>(headers);

		// ResponseEntity<String> response = restTemplate
		// .getForEntity(authorizationHost + "/api/authorization-service/validate",
		// String.class);

		ResponseEntity<String> response = restTemplate.exchange(
				authorizationHost + "/api/authorization-service/validate", HttpMethod.GET, request, String.class);

		String value = (String) response.getBody();

		if (value.equalsIgnoreCase("Invalid")) {

			throw new BusinessException(400, "Invalid jwt");
		}

		else if (value.equalsIgnoreCase("valid")) {

			Pensioner pensioner = pensionerRepository.save(pd.getPensioner());
			Bankdetail bankdetail = bankdetailRepository.save(pd.getBankdetail());

			pensionerDetail.setPensioner(pensioner);
			pensionerDetail.setBankdetail(bankdetail);

		}

		return pensionerDetail;
	}

	@Override
	public List<PensionerDetail> getPensionersDetail(String header) {

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", header);
		HttpEntity<String> request = new HttpEntity<String>(headers);

		List<Pensioner> pensioners = new ArrayList<>();
		List<PensionerDetail> pensionersDetail = new ArrayList<>();

		// ResponseEntity<String> response = restTemplate
		// .getForEntity(authorizationHost +
		// "/api/authorization-service/validate",request, String.class);

		ResponseEntity<String> response = restTemplate.exchange(
				authorizationHost + "/api/authorization-service/validate", HttpMethod.GET, request, String.class);

		String value = (String) response.getBody();

		if (value.equalsIgnoreCase("Invalid")) {

			throw new BusinessException(400, "Invalid jwt");
		}

		else if (value.equalsIgnoreCase("valid")) {

			pensioners = pensionerRepository.findAll();

			for (Pensioner pn : pensioners) {

				Bankdetail bankdetail = bankdetailRepository.findById(pn.getAadhaar_number()).get();
				PensionerDetail pd = new PensionerDetail();

				pd.setPensioner(pn);
				pd.setBankdetail(bankdetail);

				pensionersDetail.add(pd);

			}

		}

		return pensionersDetail;
	}

}
