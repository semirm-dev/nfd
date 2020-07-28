package com.jafp.nfd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.jafp.nfd.repository")
@EntityScan(basePackages = "com.jafp.nfd.entity")
@SpringBootApplication
public class NeedForDentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeedForDentalApplication.class, args);
	}

}
