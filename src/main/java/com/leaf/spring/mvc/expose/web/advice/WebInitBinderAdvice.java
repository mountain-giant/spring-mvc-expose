package com.leaf.spring.mvc.expose.web.advice;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class WebInitBinderAdvice {

    @InitBinder
    public void param(WebDataBinder binder) {
        System.out.println("------- WebInitBinderAdvice -------");
    }
}
