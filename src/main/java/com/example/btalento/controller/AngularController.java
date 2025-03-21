package com.example.btalento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AngularController {

    @GetMapping(value = {"/", "/{path:[^\\.]*}"})
    public String forwardToAngular() {
        return "forward:/index.html";
    }
}
