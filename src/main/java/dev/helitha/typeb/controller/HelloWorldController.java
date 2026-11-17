package dev.helitha.typeb.controller;

import dev.helitha.typeb.service.HelloWorldService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloWorldController {
    private final HelloWorldService helloWorldService;

    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }


    @GetMapping("/hello-world")
    public ResponseEntity<Map<String, String>> hello(@RequestParam(required = false) String name) {
        if (!helloWorldService.checkValidity(name)) {
            return ResponseEntity.badRequest().body(Map.of("error", "Invalid Input"));
        }

        return ResponseEntity.ok().body(Map.of("message", "Hello Alice"));

    }

}
