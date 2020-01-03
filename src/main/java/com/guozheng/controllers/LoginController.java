package com.guozheng.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class LoginController {

    @GetMapping(value = "/login")
    public String login() {
        log.info("Routed to login...");
        return "authentication/login";
    }

    @PostMapping(value = "/login_callback")
    public String loginCallBack(Model model) {
        log.info("Login callback...");
        return "forward:/user_login";
    }
}
