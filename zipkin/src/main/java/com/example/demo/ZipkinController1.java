package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ZipkinController1 {
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping("/aaa")
    public String aaa() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8080/ggg", String.class);

        return forEntity.getBody();
    }
}
