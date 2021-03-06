package com.bxw.lesson3configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Lesson3ConfigClientApplication {

	//冒号后面代表：如果没设置参数，就取冒号后面的值作为默认值
	@Value("${message: Hello World}")
	String msg;

	@RequestMapping(value = "/")
	String home() {
		return "获取的参数值："+msg;
	}

	public static void main(String[] args) {
		SpringApplication.run(Lesson3ConfigClientApplication.class, args);
	}
}

/*

访问  http://localhost:8080/
返回结果：// 获取的参数值：hello-dev!

*/



