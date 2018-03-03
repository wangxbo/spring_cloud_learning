package com.bxw.lesson8.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GeneralControllerAdvice {

    /**
     * 处理 404
     *
     * @param throwable
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public String handle404(Throwable throwable) {
        return "Page was not found!";
    }
}
