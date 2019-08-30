package com.zkn.demo.dao;

import com.zkn.demo.dto.data.Event;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * @author 郑凯努
 * @version 1.0
 * @date 2019/8/29
 */
@Repository
public interface EventRepository extends ReactiveMongoRepository<Event, Long> {

    @Tailable
    Flux<Event> findBy();
}
