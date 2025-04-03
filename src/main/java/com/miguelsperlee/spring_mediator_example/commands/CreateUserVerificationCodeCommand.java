package com.miguelsperlee.spring_mediator_example.commands;

import com.miguelsperlee.spring_mediator_example.mediator.abstractions.ICommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserVerificationCodeCommand implements ICommand<Void> {
    private String userId;
}
