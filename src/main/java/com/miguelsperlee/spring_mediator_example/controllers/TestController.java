package com.miguelsperlee.spring_mediator_example.controllers;

import com.miguelsperlee.spring_mediator_example.usecases.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {
    private final CreateUserUseCase createUserUseCase;

    @PostMapping("/user")
    public ResponseEntity<Object> test() {
        this.createUserUseCase.execute();

        return ResponseEntity.noContent().build();
    }
}