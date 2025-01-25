package com.miguelsperlee.spring_mediator_example.mediator.abstractions;

/**
 * @param <IN>  The type of request that will be handled
 * @param <OUT> The type of response that will be produced when handling the request.
 */
public interface RequestHandler<IN extends Request<OUT>, OUT> {
    OUT handle(IN input);
}
