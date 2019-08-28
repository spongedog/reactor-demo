package com.zkn;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * @author 郑凯努
 * @version 1.0
 * @date 2019/8/19
 */
public class SchedulerTest {

    @Test
    public void testPublishOn() {
        Flux.range(0, 10)
                .log()
                .publishOn(Schedulers.newParallel("myParallel"))
                .log()
                .subscribeOn(Schedulers.newElastic("myElastic"))
//                .log()
                .blockLast();
    }
}
