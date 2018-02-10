package com.bxw.lesson5eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Lesson5EurekaServerApplication {

	//启动 Peer 1 Eureka 服务器
	//通过启动参数 —spring.profiles.active=peer1 ,相当于读取了 application-peer1.properties和 application.properties


	//启动 Peer 2 Eureka 服务器
	//通过启动参数 —spring.profiles.active=peer2 ,相当于读取了 application-peer2.properties和 application.properties

	//两个Eureka服务器相互扶持，降低注册中心宕机，全部不可用的几率

	public static void main(String[] args) {
		SpringApplication.run(Lesson5EurekaServerApplication.class, args);
	}
}
