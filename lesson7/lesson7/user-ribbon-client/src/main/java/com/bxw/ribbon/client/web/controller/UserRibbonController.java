package com.bxw.ribbon.client.web.controller;

import com.bxw.ribbon.client.hystrix.UserRibbonClientHystrixCommand;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collection;

/**
 * Created by wxb on 2018/2/27.
 */
@RestController
public class UserRibbonController {
    //负载均衡器客户端
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Value("${provider.service.name}")
    private String providerServiceName;
    //providerServiceName 的值是 user-service-provider

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("")
    public String index() throws IOException{
        User user = new User();
        user.setId(1L);
        user.setName("bxw");
        //选择指定的Service
        ServiceInstance serviceInstance = loadBalancerClient.choose(providerServiceName);
        return loadBalancerClient.execute(providerServiceName, serviceInstance, instance ->{
           //服务器实例，获取主机IP和端口
            String host = instance.getHost();
            int port = instance.getPort();
            String url = "http://"+host+":"+port+"/user/save";
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.postForObject(url, user, String.class);
        });

    }


    //访问的时候，可以看到服务提供方的
    @GetMapping("/user-service-provider/user/list")
    public Collection<User> getUsersList(){
        return new UserRibbonClientHystrixCommand(providerServiceName, restTemplate).execute();
    }


}
