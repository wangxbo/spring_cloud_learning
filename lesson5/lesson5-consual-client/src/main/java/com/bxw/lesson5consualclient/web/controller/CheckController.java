package com.bxw.lesson5consualclient.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 检查 Controller
 * Created by wxb on 2018/2/10.
 */
@RestController
public class CheckController {

    @GetMapping("/check")
    public String check(){
        return "ok";
    }

}
