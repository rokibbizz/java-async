package com.example.demo.infrastructure.service;

import com.example.demo.application.service.IHomeService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
public class HomeService implements IHomeService {

    @Override
    public String getA() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return "A";
    }

    @Override
    public String getB() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return "B";
    }

    @Override
    public String getC() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return "C";
    }

    @Async(value = "asyncExecutor")
    @Override
    public CompletableFuture<String> getSpring_CF_A() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return CompletableFuture.completedFuture("A");
    }

    @Async(value = "asyncExecutor")
    @Override
    public CompletableFuture<String> getSpring_CF_B() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return CompletableFuture.completedFuture("B");
    }

    @Async(value = "asyncExecutor")
    @Override
    public CompletableFuture<String> getSpring_CF_C() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return CompletableFuture.completedFuture("C");
    }

    @Override
    public CompletableFuture<String> getJoin_CF_A() {
        CompletableFuture<String> A = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "A";
        });
        return A;
    }

    @Override
    public CompletableFuture<String> getJoin_CF_B() {
        CompletableFuture<String> B = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "B";
        });
        return B;
    }

    @Override
    public CompletableFuture<String> getJoin_CF_C() {
        CompletableFuture<String> C = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "C";
        });
        return C;
    }
}
