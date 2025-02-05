package com.miguelsperlee.spring_mediator_example.mediator;

import com.miguelsperlee.spring_mediator_example.mediator.abstractions.Mediator;
import com.miguelsperlee.spring_mediator_example.mediator.abstractions.Request;
import com.miguelsperlee.spring_mediator_example.mediator.abstractions.RequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;

/**
 * Spring mediator makes use of springs IoC container in order to resolve given requests. Any RequestHandlers that
 * are registered as beans will be able to be found by using the ApplicationContext.
 * In short this class is responsible by looking for a specify handle to lead with a specify request, based on the type of the request.
 */

@Component
@RequiredArgsConstructor
public class SpringMediator implements Mediator {
    private final AbstractApplicationContext abstractApplicationContext;

    @Override
    @SuppressWarnings("unchecked")
    public <OUT> OUT send(Request<OUT> request) {
        if (request == null) {
            throw new NullPointerException("The given request object cannot be null");
        }

        final Class requestType = request.getClass();
        final Class<OUT> responseType = (Class<OUT>) ((ParameterizedType) requestType.getGenericInterfaces()[0]).getActualTypeArguments()[0];

        final String[] beanNames = this.abstractApplicationContext.getBeanNamesForType(ResolvableType.forClassWithGenerics(RequestHandler.class, requestType, responseType));

        if (beanNames.length == 0) {
            throw new IllegalStateException("No handlers seemed to be registered to handle the given request. Make sure the handler is defined and marked as a spring component");
        }

        if (beanNames.length > 1) {
            throw new IllegalStateException("More than one handlers found. Only one handler per request is allowed.");
        }

        final RequestHandler<Request<OUT>, OUT> requestHandler = (RequestHandler<Request<OUT>, OUT>) this.abstractApplicationContext.getBean(beanNames[0]);

        return requestHandler.handle(request);
    }
}
