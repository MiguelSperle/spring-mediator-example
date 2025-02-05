package com.miguelsperlee.spring_mediator_example.request;

import com.miguelsperlee.spring_mediator_example.mediator.abstractions.Request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestRequest implements Request<String> {
    private String testId;
}
