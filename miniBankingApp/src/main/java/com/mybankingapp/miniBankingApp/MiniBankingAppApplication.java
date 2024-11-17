package com.mybankingapp.miniBankingApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication
//@EnableJpaRepositories
//@EnableJpaRepositories(basePackages = "com.mybankingapp.miniBankingApp.repository")
@ComponentScan(basePackages = {"com.mybankingapp.miniBankingApp"})
@SpringBootApplication(scanBasePackages = "com.mybankingapp.miniBankingApp")
@EnableJpaRepositories(basePackages = "com.mybankingapp.miniBankingApp.repository")
@EntityScan(basePackages = "com.mybankingapp.miniBankingApp.model")
public class MiniBankingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniBankingAppApplication.class, args);
	}

}
