package com.zkn.demo.controller;

import com.zkn.demo.dao.UserRepository;
import com.zkn.demo.dto.data.User;
import com.zkn.demo.dto.request.AddUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @author 郑凯努
 * @version 1.0
 * @date 2019/8/23
 */
@RestController
@RequestMapping(value = "/user_center")
@AllArgsConstructor
public class UserController {

    private UserRepository userRepository;

    @GetMapping(path = "/user")
    public Mono<User> getUser(@RequestParam Long id) {
        return userRepository.findById(id);
    }

    @PostMapping(path = "/user")
    public Mono<User> addUser(@RequestBody AddUserRequest request) {
        User user = new User().setId(request.getId()).setName(request.getName());
        return userRepository.insert(user);
    }

    @GetMapping(path = "/user_all")
    public Flux<User> getAllUser() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/user_all_delay", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<User> getAllUserDelay() {
        return userRepository.findAll().delayElements(Duration.ofSeconds(1));
    }

    private String generateUserKey(String name) {
        return String.format("USER_%s", name);
    }
}
