package com.bxw.ribbon.client;

import com.bxw.ribbon.client.rule.MyRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;

/**
 * Created by wxb on 2018/2/27.
 */
@SpringBootApplication
@RibbonClient("user-service-provider")
public class UserRibbonClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserRibbonClientApplication.class, args);
    }

    @Bean
    public IRule myRule(){
        return new MyRule();
    }

}
