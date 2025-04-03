package com.miguelsperlee.spring_mediator_example.mediator.abstractions;

/**
 * @param <IN>  The type of command that will be handled
 * @param <OUT> The type of response that will be produced when handling the command.
 */
public interface ICommandHandler<IN extends ICommand<OUT>, OUT> {
    OUT handle(IN input);
}
