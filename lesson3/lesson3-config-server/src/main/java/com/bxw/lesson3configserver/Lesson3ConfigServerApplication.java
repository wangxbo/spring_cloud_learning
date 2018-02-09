package com.bxw.lesson3configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Lesson3ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lesson3ConfigServerApplication.class, args);
	}
}

	/*
	说明：获取git上的资源信息遵循如下规则：

	/{application}/{profile}[/{label}]
	/{application}-{profile}.yml
	/{label}/{application}-{profile}.yml
	/{application}-{profile}.properties
	/{label}/{application}-{profile}.properties

	application:表示应用名称,在配置文件中通过spring.config.name配置，如果不配置这使用spring.application.name值
	profile:表示获取指定环境下配置，例如开发环境、测试环境、生产环境 默认值default，实际开发中可以是 dev、test、demo、production等
	label: git标签，默认值master

	*/

