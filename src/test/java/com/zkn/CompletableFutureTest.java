package com.zkn;

import java.util.concurrent.CompletableFuture;

/**
 * @author 郑凯努
 * date 2019/7/31
 * version 1.0
 */
public class CompletableFutureTest {

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> "Hello").thenCombine(CompletableFuture.completedFuture("Java"), (s1, s2) -> s1 +s2)
                .thenAccept(System.out::println);
    }
}
