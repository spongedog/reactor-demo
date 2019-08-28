package com.zkn.demo.controller;

import com.zkn.demo.data.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author 郑凯努
 * @version 1.0
 * @date 2019/8/23
 */
@RestController
@RequestMapping(value = "/user_center")
public class UserController {

    @GetMapping(path = "/user")
    public User getUser() {
        return new User().setId(33L).setName("海绵狗狗");
    }

    @GetMapping(path = "/user2")
    public Mono<User> getUser2() {
        return Mono.just(new User().setId(33L).setName("海绵狗狗"));
    }
}
