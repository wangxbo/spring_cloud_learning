package com.bxw.lesson8.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeoutException;



@RestController
public class DemoRestController {

    private final static Random random = new Random();

    /**
     * 当方法执行时间超过 100 ms 时，触发异常
     *
     * @return
     */
    @GetMapping("")
    public String index() throws Exception {

        long executeTime = random.nextInt(200);

        if (executeTime > 100) { // 执行时间超过了 100 ms
            throw new TimeoutException("Execution is timeout!");
        }

        return "Hello,World";
    }

}
