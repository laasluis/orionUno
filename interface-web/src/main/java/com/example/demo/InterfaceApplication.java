package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.example.demo.*")
@ComponentScan(basePackages = {"com.example.demo.*"})
@EntityScan(basePackages = {"com.example.demo.*"})
@EnableFeignClients

public class InterfaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterfaceApplication.class, args);
	}

}
