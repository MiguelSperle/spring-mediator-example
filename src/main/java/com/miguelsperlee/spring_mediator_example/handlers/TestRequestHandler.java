package com.miguelsperlee.spring_mediator_example.handlers;

import com.miguelsperlee.spring_mediator_example.mediator.abstractions.RequestHandler;
import com.miguelsperlee.spring_mediator_example.request.TestRequest;
import org.springframework.stereotype.Component;

@Component
public class TestRequestHandler implements RequestHandler<TestRequest, String> {
    @Override
    public String handle(TestRequest testRequest) {
        return "Message " + testRequest.getTestId();
    }
}
