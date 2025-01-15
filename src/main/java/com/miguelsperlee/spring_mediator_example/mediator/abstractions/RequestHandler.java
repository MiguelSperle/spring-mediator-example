package com.miguelsperlee.spring_mediator_example.mediator.abstractions;

/**
 * @param <TRequest>  The type of request that will be handled
 * @param <TResponse> The type of response that will be produced when handling the request.
 */
public interface RequestHandler<TRequest extends Request<TResponse>, TResponse> {
    /**
     * @param request The request instance that was passed through mediator object.
     * @return The result of handling the given request.
     */
    TResponse handle(TRequest request);
}
