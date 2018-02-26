package com.bxw.lesson6serviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Lesson6ServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lesson6ServiceProviderApplication.class, args);
	}
}
