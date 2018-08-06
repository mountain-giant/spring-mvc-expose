package com.leaf.spring.mvc.expose.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(Model model) {

        model.addAttribute("name","requestMappingHandler");
        model.addAttribute("age","18");
        return "index";
    }

    @ResponseBody
    @RequestMapping("/topic")
    public String topic(String name) {
        return "hahaha";
    }

    @ResponseBody
    @RequestMapping("/home")
    public String topic(long id) {
        return "topic";
    }

}
