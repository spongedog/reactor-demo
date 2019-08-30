package com.zkn;

import reactor.core.publisher.Flux;

/**
 * @author 郑凯努
 * @version 1.0
 * @date 2019/8/29
 */
public class JustTest {

    public static void main(String[] args) {
        Flux.just(0, 1, 2, 3, 4, 5, 6, 7).map(i -> i * 2).filter(i -> i < 10).subscribe(System.out::println);
    }
}
