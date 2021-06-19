package com.main.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.model.restservice.UserRepository;

@ComponentScan("com.controller")
@ComponentScan(basePackages = {"com.security"})
@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class MainApplication {
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
}
