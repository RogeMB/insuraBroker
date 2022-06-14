package com.salesianostriana.dam.correduriacrm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicController {

    @GetMapping("/")
    public String welcome() {
        return "index";
    }
    
    @GetMapping("/index")
    public String index() {
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