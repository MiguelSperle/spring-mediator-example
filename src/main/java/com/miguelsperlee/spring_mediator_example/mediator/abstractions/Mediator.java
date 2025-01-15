package com.miguelsperlee.spring_mediator_example.mediator.abstractions;

public interface Mediator {
    /**
     * @param request The request that will be handled by its registered handler, if it exists.
     * @param <TResponse>     The type of the response that will be returned.
     * @return The result of the executed handler.
     */
    <TResponse> TResponse send(Request<TResponse> request);
}
