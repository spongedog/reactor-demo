package com.zkn;

import com.zkn.demo.dto.data.Event;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;

/**
 * @author 郑凯努
 * @version 1.0
 * @date 2019/8/29
 */
public class EventClientTest {

    @Test
    public void testEvent() {
        Random random = new Random();
        Flux<Event> eventFlux = Flux.interval(Duration.ofSeconds(1))
                .map(l -> new Event(random.nextLong(), "test message" + l)).take(5);
        WebClient webClient = WebClient.create("http://localhost:10999");

        webClient.post().uri("/event_center/events")
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(eventFlux, Event.class)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    @Test
    public void testGet() {
        WebClient webClient = WebClient.create("http://localhost:10999");
        webClient.get().uri("/event_center/events")
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .retrieve()
                .bodyToFlux(String.class)
                .log()
                .take(10)
                .blockLast();
    }
}
