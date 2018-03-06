package com.bxw.service.web.controller;

import api.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 *用户服务提供方
 * Created by wxb on 2018/2/27.
 */
@RestController
public class UserServiceProviderController implements UserService{

    @Autowired
    @Qualifier("inMemoryUserService")
    // 实现 Bean ： InMemoryUserService
    private UserService userService;

    @Value("${server.port}")
    private String port;

    private final static Random random = new Random();

    //通过方法继承， URL映射: "/user/save"
    @Override
    public boolean saveUser(@RequestBody  User user) {
        return userService.saveUser(user);
    }


    @HystrixCommand(
            commandProperties = {
                 //设置操作时间为100毫秒
                 @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
            },
            fallbackMethod = "fallbackForGetUsers"
    )
    //通过方法继承, URL 映射: "/user/find/all"
    @Override
    public List<User> findAll() {
        return userService.findAll();
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
    public List<User> getUsers() throws InterruptedException{
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
    public List<User> fallbackForGetUsers(){
        return Collections.emptyList();
    }


}
