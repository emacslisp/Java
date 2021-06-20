package com.main.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.main.boot.model.UserRepository;

@ComponentScan("com.controller")
@ComponentScan(basePackages = {"com.security"})
@SpringBootApplication
@EntityScan(basePackages ={"com.main.boot.model"})
@EnableJpaRepositories(basePackages = {"com.main.boot.model"})
@PropertySource("classpath:application.properties")
public class MainApplication {
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
}
