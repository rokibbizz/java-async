package com.example.demo.application.service;

import java.util.concurrent.CompletableFuture;

public interface IHomeService {
    String getA() throws InterruptedException;

    String getB() throws InterruptedException;

    String getC() throws InterruptedException;

    CompletableFuture<String> getSpring_CF_A() throws InterruptedException;

    CompletableFuture<String> getSpring_CF_B() throws InterruptedException;

    CompletableFuture<String> getSpring_CF_C() throws InterruptedException;

    CompletableFuture<String> getJoin_CF_A();

    CompletableFuture<String> getJoin_CF_B();

    CompletableFuture<String> getJoin_CF_C();
}
