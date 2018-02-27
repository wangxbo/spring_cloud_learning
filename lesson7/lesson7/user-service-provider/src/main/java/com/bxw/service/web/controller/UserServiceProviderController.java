package com.bxw.service.web.controller;

import api.UserService;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *用户服务提供方
 * Created by wxb on 2018/2/27.
 */
@RestController
public class UserServiceProviderController {

    @Autowired
    private UserService userService;

    @Value("${server.port}")
    private String port;

    @PostMapping("/user/save")
    public boolean save(@RequestBody User user){
        System.out.println("端口号为"+ port +"的服务器保存了一个用户" + user.toString());
        return userService.saveUser(user);
    }


}
