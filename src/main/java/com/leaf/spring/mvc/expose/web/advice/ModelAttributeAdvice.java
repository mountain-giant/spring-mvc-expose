package com.leaf.spring.mvc.expose.web.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class ModelAttributeAdvice {

    @ModelAttribute
    public void pre() {
        System.out.println("------- ModelAttributeAdvice ---------");
    }

}
