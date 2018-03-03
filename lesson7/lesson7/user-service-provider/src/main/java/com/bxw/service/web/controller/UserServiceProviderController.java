package com.bxw.service.web.controller;

import api.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;

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

    private final static Random random = new Random();

    @PostMapping("/user/save")
    public boolean save(@RequestBody User user){
        System.out.println("端口号为"+ port +"的服务器保存了一个用户" + user.toString());
        return userService.saveUser(user);
    }

    @HystrixCommand(
            commandProperties = {
                    //设置操作时间为100毫秒
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
            },
            //设置fallback方法
            fallbackMethod = "fallbackForGetUsers"
    )
    @GetMapping("/user/list")
    public Collection<User> getUsers() throws InterruptedException{
        long executeTime = random.nextInt(200);
        // 通过休眠来模拟执行时间
        System.out.println("Execute Time : " + executeTime + " ms");
        Thread.sleep(executeTime);
        return userService.findAll();
    }

    /**
     * getUser的fallback方法
     * @return
     */
    public Collection<User> fallbackForGetUsers(){
        return Collections.emptyList();
    }

}
