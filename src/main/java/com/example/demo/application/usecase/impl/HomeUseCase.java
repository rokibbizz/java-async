package com.example.demo.application.usecase.impl;

import com.example.demo.application.service.IHomeService;
import com.example.demo.application.usecase.IHomeUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class HomeUseCase implements IHomeUseCase {

    @Autowired
    private IHomeService homeService;

    @Override
    public ResponseEntity<String> getdata() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        String A = homeService.getA();
        String B = homeService.getB();
        String C = homeService.getC();
        String res = A + " " + B + " " + C + " WithOut Async Total Response Time: "+ ((System.currentTimeMillis() - startTime) / 1000) + " seconds";
        System.out.println("total time " + ((System.currentTimeMillis() - startTime) / 1000) + " seconds");

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> getdataAsync() throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> {
            try {
                return homeService.getA();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> {
            try {
                return homeService.getB();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<String> futureC = CompletableFuture.supplyAsync(() -> {
            try {
                return homeService.getC();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        String A = futureA.get();
        String B = futureB.get();
        String C = futureC.get();
        System.out.println("total time " + ((System.currentTimeMillis() - startTime) / 1000) + " seconds");
        String res = A + " " + B + " " + C + " with async Total Response Time: "+ ((System.currentTimeMillis() - startTime) / 1000) + " seconds";

        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<String> getDataSpringAsync() throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();

        CompletableFuture<String> CF_A = homeService.getSpring_CF_A();
        CompletableFuture<String> CF_B = homeService.getSpring_CF_B();
        CompletableFuture<String> CF_C = homeService.getSpring_CF_C();
        CompletableFuture.allOf(CF_A, CF_B, CF_C).join();

        String A = CF_A.get();
        String B = CF_B.get();
        String C = CF_C.get();

        String res = A + " " + B + " " + C + " WithSpringBoot Async Total Response Time: "+ ((System.currentTimeMillis() - startTime) / 1000) + " seconds";
        System.out.println("total time " + ((System.currentTimeMillis() - startTime) / 1000) + " seconds");

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> getDataJoinAsync() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();

        CompletableFuture<String> CF_A = homeService.getJoin_CF_A();
        CompletableFuture<String> CF_B = homeService.getJoin_CF_B();
        CompletableFuture<String> CF_C = homeService.getJoin_CF_C();
        CompletableFuture.allOf(CF_A, CF_B, CF_C).join();

        String A = CF_A.get();
        String B = CF_B.get();
        String C = CF_C.get();
        String res = A + " " + B + " " + C + " WithJoin Async Total Response Time: "+ ((System.currentTimeMillis() - startTime) / 1000) + " seconds";
        System.out.println("total time " + ((System.currentTimeMillis() - startTime) / 1000) + " seconds");

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
