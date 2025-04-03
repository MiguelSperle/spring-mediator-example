package com.miguelsperlee.spring_mediator_example.mediator.abstractions;

public interface IMediator {
    /**
     * @param command The command that will be handled by its command handler, if it exists.
     * @param <OUT> The type of the response that will be returned.
     * @return The result of the executed handler.
     */

    <OUT> OUT send(ICommand<OUT> command);
}
