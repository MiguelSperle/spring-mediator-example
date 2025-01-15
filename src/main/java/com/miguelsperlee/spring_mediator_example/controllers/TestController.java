package com.miguelsperlee.spring_mediator_example.controllers;

import com.miguelsperlee.spring_mediator_example.mediator.abstractions.Mediator;
import com.miguelsperlee.spring_mediator_example.request.TestRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final Mediator mediator;

    @PostMapping("test")
    public ResponseEntity<Object> test(@RequestBody TestRequest testRequest) {
        this.mediator.send(testRequest);

        return ResponseEntity.ok().body("Success");
    }
}