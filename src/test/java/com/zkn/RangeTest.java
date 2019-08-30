package com.zkn;

import reactor.core.publisher.Flux;

/**
 * @author 郑凯努
 * date 2019/7/31
 * version 1.0
 */
public class RangeTest {

    public static void main(String[] args) {
        Flux.range(0, 100).map(i -> i * 2).filter(i -> i < 150).subscribe(System.out::println);
    }
}
