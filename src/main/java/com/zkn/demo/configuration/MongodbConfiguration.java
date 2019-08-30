package com.zkn.demo.configuration;

import com.zkn.demo.dto.data.Event;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 * @author 郑凯努
 * @version 1.0
 * @date 2019/8/29
 */
@Configuration
public class MongodbConfiguration {

    @Bean
    public CommandLineRunner initData(MongoOperations mongo) {
        return (String... args) -> {
            mongo.dropCollection(Event.class);
            mongo.createCollection(Event.class, CollectionOptions.empty().size(100000).capped());
        };
    }
}
