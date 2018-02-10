package com.bxw.lesson5eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Lesson5EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lesson5EurekaClientApplication.class, args);
	}
}
