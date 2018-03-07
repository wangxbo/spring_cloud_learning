package com.neo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	private final Logger logger = LoggerFactory.getLogger(HelloController.class);


	//为什么直接调用服务，打一条日志，说明调用了一次。。。当通过zuul调用时，会有两条日志，重复调用
    @RequestMapping("/hello")
    public String index(@RequestParam String name){
        logger.info("request two name is "+name);
        try{
            Thread.sleep(1000000);
        }catch ( Exception e){
            logger.error(" hello two error",e);
        }
        return "hello "+name+"，this is two messge";
    }
}