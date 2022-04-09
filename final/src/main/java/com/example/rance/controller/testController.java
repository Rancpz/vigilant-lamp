package com.example.rance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("tp")
public class testController {

    @RequestMapping("test1")
    public String test1(){
        System.out.println("成功！");
        return "index";
    }
}
