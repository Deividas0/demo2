package com.example.manoapi.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/first")
    public String firstEndpoint()
    {
        return "My First Endpoint Response to your request";
    }
}
