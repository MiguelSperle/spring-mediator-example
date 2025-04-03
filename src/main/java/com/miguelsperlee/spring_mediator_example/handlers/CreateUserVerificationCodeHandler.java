package com.miguelsperlee.spring_mediator_example.handlers;

import com.miguelsperlee.spring_mediator_example.mediator.abstractions.ICommandHandler;
import com.miguelsperlee.spring_mediator_example.commands.CreateUserVerificationCodeCommand;
import com.miguelsperlee.spring_mediator_example.usecases.CreateUserVerificationCodeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateUserVerificationCodeHandler implements ICommandHandler<CreateUserVerificationCodeCommand, Void> {
    private final CreateUserVerificationCodeUseCase createUserVerificationCodeUseCase;

    @Override
    public Void handle(CreateUserVerificationCodeCommand createUserVerificationCodeCommand) {
        this.createUserVerificationCodeUseCase.execute(createUserVerificationCodeCommand.getUserId());

        return null;
    }
}
