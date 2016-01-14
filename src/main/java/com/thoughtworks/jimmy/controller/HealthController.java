package com.thoughtworks.jimmy.controller;

import com.thoughtworks.jimmy.model.Health;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @RequestMapping("/")
    public Health health() {
        return new Health("RESTful API: Up and Running!");
    }
}
