package com.bxw.lesson5consualclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Lesson5ConsualClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lesson5ConsualClientApplication.class, args);
	}
}
