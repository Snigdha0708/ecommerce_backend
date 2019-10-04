package com.caseStudy.eCommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ECommerceApplication {

	public static void main(String[] args) {
		SpringApplication springApplication=new SpringApplication(ECommerceApplication.class);
		springApplication.run(args);
	}

}
