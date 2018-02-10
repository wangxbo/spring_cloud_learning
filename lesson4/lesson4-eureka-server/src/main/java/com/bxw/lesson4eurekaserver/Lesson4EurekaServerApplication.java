package com.bxw.lesson4eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Lesson4EurekaServerApplication {

	public static void main(String[] args) {
		//启动成功后，直接访问http://localhost:9090/
		SpringApplication.run(Lesson4EurekaServerApplication.class, args);
	}
}
