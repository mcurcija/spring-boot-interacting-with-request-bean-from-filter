package com.example.demo.web;

import com.example.demo.model.UserContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class HelloEndpoint {

    @Autowired
    UserContext userContext;

    @GetMapping(path = "hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public HelloResponse sayHello() {
        return new HelloResponse(String.format("hello : %s", userContext));
    }

    public final class HelloResponse {
        public String message;     
        public HelloResponse(String message) {
            this.message = message;
        }
    }
}
