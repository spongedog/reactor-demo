package com.zkn.demo.controller;

import com.zkn.demo.dao.EventRepository;
import com.zkn.demo.dto.data.Event;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @author 郑凯努
 * @version 1.0
 * @date 2019/8/29
 */
@RestController
@RequestMapping(value = "/event_center")
@AllArgsConstructor
public class EventController {

    private EventRepository eventRepository;

    @GetMapping(path = "/events", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Event> getEvents() {
        return eventRepository.findBy().delayElements(Duration.ofSeconds(1));
    }

    @PostMapping(path = "/events", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<Void> addEvents(@RequestBody Flux<Event> event) {
        return eventRepository.insert(event).then();
    }

    @DeleteMapping(path = "/events")
    public Mono<Void> deleteAll() {
        return eventRepository.deleteAll();
    }
}
