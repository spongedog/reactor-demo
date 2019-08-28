package com.zkn;

import reactor.core.publisher.Flux;

/**
 * @author 郑凯努
 * date 2019/7/31
 * version 1.0
 */
public class RangeTest {

    public static void main(String[] args) {
        Flux.range(0, 100).subscribe(System.out::println);
        System.out.println("xxzz");
    }
}
