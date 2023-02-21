package com.example.demo.Presentaion.api;

import com.example.demo.application.usecase.IHomeUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private IHomeUseCase homeUseCase;

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return new ResponseEntity<>("hello ", HttpStatus.OK);
    }

    @GetMapping("/getdata")
    public ResponseEntity<String> getdata() throws InterruptedException, ExecutionException {
        return homeUseCase.getdata();
    }

    //first way applying async in java
    @GetMapping("/getdataasync")
    public ResponseEntity<String> getdataAsync() throws InterruptedException, ExecutionException {
        return homeUseCase.getdataAsync();
    }

    //second way applying async in java with async executor
    @GetMapping("/getdataspringasync")
    public ResponseEntity<String> getDataSpringAsync() throws InterruptedException, ExecutionException {
        return homeUseCase.getDataSpringAsync();
    }

    //third way applying async in java
    @GetMapping("/getdatajoingasync")
    public ResponseEntity<String> getDataJoinAsync() throws InterruptedException, ExecutionException {
        return homeUseCase.getDataJoinAsync();
    }



}
