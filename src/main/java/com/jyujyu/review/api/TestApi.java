package com.jyujyu.review.api;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestApi {

    @GetMapping("/hello/world")
    public String helloWorld() {
        return "[GET] Hello, world!";
    }

    @PostMapping("/hello/world")
    public String postHelloWorld() {
        return "[POST] Hello, world!";
    }

    @PutMapping("/hello/world")
    public String putHelloWorld() {
        return "[PUT] Hello, world!";
    }

    @DeleteMapping("/hello/world")
    public String deleteHelloWorld() {
        return "[DELETE] Hello, world!";
    }

}
