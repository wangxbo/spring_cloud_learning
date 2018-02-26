package com.bxw.lesson6serviceprovider.web.controller;

import com.bxw.lesson6serviceprovider.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wxb on 2018/2/26.
 */
@RestController
public class ServiceProviderController {
    @Value("${server.port}")
    private Integer port;

    @PostMapping("/greeting")
    public String greeting(@RequestBody User user){
        return "Greeting , " + user + " on port : " + port;
    }


}
