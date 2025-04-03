package com.miguelsperlee.spring_mediator_example.usecases;

import com.miguelsperlee.spring_mediator_example.mediator.abstractions.IMediator;
import com.miguelsperlee.spring_mediator_example.commands.CreateUserVerificationCodeCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase {
    private final IMediator mediator;

    public void execute() {
        // Logic to create user
        // This is just a placeholder for the actual implementation
        System.out.println("Creating user...");
        this.mediator.send(new CreateUserVerificationCodeCommand(
                UUID.randomUUID().toString() // I'm sending a random UUID as userId because this is just an example
        ));
    }
}
