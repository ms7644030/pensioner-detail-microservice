package com.pensionerDetail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@EnableEurekaClient
@SpringBootApplication
public class PensionerDetailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PensionerDetailServiceApplication.class, args);

	}

	@Bean
	// @LoadBalanced
	public RestTemplate restTemplate() {

		return new RestTemplate();
	}

}
