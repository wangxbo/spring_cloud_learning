package com.bxw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Created by wxb on 2018/3/3.
 */

//http://localhost:9090/hystrix.stream 放入dashboard可以看调用

//启动HystrixDashboard后，访问 http://localhost:10000/hystrix
//  http://localhost:9090/hystrix.stream  可以看到服务提供方的监控信息，这些信息让人来看比较困难
// 将 http://localhost:9090/hystrix.stream 熊头下面的那个表格里,点击monitor就能看到监控信息，调用
//  http://localhost:8080/user-service-provider/user/list 就能实时看到监控信息
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication.class, args);

    }
}
