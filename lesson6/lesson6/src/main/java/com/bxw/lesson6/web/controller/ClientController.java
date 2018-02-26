package com.bxw.lesson6.web.controller;

import com.bxw.lesson6.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wxb on 2018/2/26.
 */

@RestController
public class ClientController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-provider.host}")
    private String serviceProviderHost;

    @Value("${service-provider.port}")
    private Integer serviceProviderPort;

    @Value("${service-provider.name}")
    private String serviceProviderName;

    @GetMapping("")
    public String index(){
        User user = new User();
        user.setId(1L);
        user.setName("bxw");
        return restTemplate.postForObject("http://" + serviceProviderName + "/greeting",
                user, String.class);
    }
}
