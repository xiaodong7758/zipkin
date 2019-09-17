package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class Swagger2Controller {
    private static final Logger logger = Logger.getLogger(Swagger2Controller.class.getName());
    @Autowired
    private RestTemplate restTemplate;
    @PostMapping("/testString")
    public String testString(String name) {
        logger.log(Level.INFO, "index API is calling");
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:9091/mmm", String.class);
        return "Welcome Sleuth!"+forEntity.getBody();
    }

    @GetMapping("/testInger/{age}")
    public int testInger(@PathVariable int age) {
        return age;
    }
}
