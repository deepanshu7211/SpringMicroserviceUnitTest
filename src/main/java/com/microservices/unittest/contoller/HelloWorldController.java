package com.microservices.unittest.contoller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld()
    {
        return "Hello World";
    }

    @PostMapping("/hello-world")
    public ResponseEntity<String> postHelloWorld(@RequestBody String request)
    {
        System.out.println("reuqet " + request);
        return new ResponseEntity<String>("hello-world from post", HttpStatus.CREATED);
    }
}
