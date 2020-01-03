package com.guozheng.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//If you want to render webpages, do not use the @RestController annotation. Use @Controller instead.
@Slf4j
@Controller
@RequestMapping(value = "/")
public class HomeController {

    @GetMapping(value = "/home")
    public String home() {
        return "home";
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "sample/hello";
    }
}
