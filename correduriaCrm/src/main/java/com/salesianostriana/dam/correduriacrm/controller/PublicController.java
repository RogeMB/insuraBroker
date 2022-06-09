package com.salesianostriana.dam.correduriacrm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicController {

    private static final Logger log = LoggerFactory.getLogger(PublicController.class);

    @GetMapping("/")
    public String welcome() {
        return "index";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @GetMapping("/error404")
    public String error404() {
        return "error404";
    }

    @GetMapping("/redirect")
    public String redirect() {
        return "redirect:/login-login-in";
    }

}