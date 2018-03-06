package com.bxw.ribbon.client;

import api.UserService;
import com.bxw.ribbon.client.rule.MyRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wxb on 2018/2/27.
 */
@SpringBootApplication
//指定目标应用名称
@RibbonClient("user-service-provider")
//使用服务短路
@EnableCircuitBreaker
//申明UserService接口作为Feign Client调用
@EnableFeignClients(clients = UserService.class)
//激活服务发现客户端
@EnableDiscoveryClient
public class UserRibbonClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserRibbonClientApplication.class, args);
    }

    /**
     * 将 {@link MyRule} 暴露为 {@link Bean}
     * @return
     */
    @Bean
    public IRule myRule(){
        return new MyRule();
    }

    /**
     * 申明 具有负载均衡能力{@link RestTemplate}
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
