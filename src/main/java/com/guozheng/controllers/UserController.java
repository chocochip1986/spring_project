package com.guozheng.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class UserController {

    @PostMapping(value = "/user_login")
    private void userLogin() {
        log.info("/user_login");

    }
}
