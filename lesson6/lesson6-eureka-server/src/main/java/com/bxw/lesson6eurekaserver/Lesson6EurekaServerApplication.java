package com.bxw.lesson6eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Lesson6EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lesson6EurekaServerApplication.class, args);
	}
}
