package com.bxw.lesson8.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.concurrent.TimeoutException;


@RestControllerAdvice(assignableTypes = DemoRestController.class)
public class DemoRestControllerAdvice {

    @ExceptionHandler(TimeoutException.class)
    public Object faultToleranceTimeout(Throwable throwable) {
        return throwable.getMessage();
    }
}
