package com.miguelsperlee.spring_mediator_example.mediator.abstractions;

/**
 * @param <TRequest>  The type of request that will be handled
 * @param <TResponse> The type of response that will be produced when handling the request.
 */
public interface RequestHandler<TRequest extends Request<TResponse>, TResponse> {
    TResponse handle(TRequest request);
}
