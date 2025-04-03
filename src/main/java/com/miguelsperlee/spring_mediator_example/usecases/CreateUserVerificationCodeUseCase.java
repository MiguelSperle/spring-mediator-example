package com.miguelsperlee.spring_mediator_example.usecases;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserVerificationCodeUseCase {
    public void execute(String userId) {
        // Logic to create user verification code
        // This is just a placeholder for the actual implementation
        System.out.println("Creating user verification code... with user id " + userId);
    }
}
