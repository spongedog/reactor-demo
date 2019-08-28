package com.zkn.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author 郑凯努
 * date 2019/7/31
 * version 1.0
 */
@RestController
@RequestMapping(value = "/demo")
public class DemoController {

    @RequestMapping(path = "hello_world")
    public Mono<String> helloWorld() {
        return Mono.just("helloWorld");
    }
}
