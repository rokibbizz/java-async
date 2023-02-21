package com.example.demo.application.usecase;

import org.springframework.http.ResponseEntity;

import java.util.concurrent.ExecutionException;

public interface IHomeUseCase {
    ResponseEntity<String> getdataAsync() throws InterruptedException, ExecutionException;

    ResponseEntity<String> getdata() throws InterruptedException;

    ResponseEntity<String> getDataSpringAsync() throws InterruptedException, ExecutionException;

    ResponseEntity<String> getDataJoinAsync() throws InterruptedException, ExecutionException;
}
