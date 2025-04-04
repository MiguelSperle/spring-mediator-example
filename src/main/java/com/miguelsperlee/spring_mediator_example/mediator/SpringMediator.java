package com.miguelsperlee.spring_mediator_example.mediator;

import com.miguelsperlee.spring_mediator_example.mediator.abstractions.ICommand;
import com.miguelsperlee.spring_mediator_example.mediator.abstractions.IMediator;
import com.miguelsperlee.spring_mediator_example.mediator.abstractions.ICommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;

/**
 * Spring mediator makes use of springs IoC container in order to resolve given commands. Any CommandHandlers that
 * are registered as beans will be able to be found by using the ApplicationContext.
 * In short this class is responsible by looking for a specify handle to lead with a specify command, based on the type of the command.
 */

@Component
@RequiredArgsConstructor
public class SpringMediator implements IMediator {
    private final AbstractApplicationContext abstractApplicationContext;

    @Override
    @SuppressWarnings("unchecked")
    public <OUT> OUT send(ICommand<OUT> command) {
        if (command == null) {
            throw new NullPointerException("The given command object cannot be null");
        }

        // Types used to find the exact handler that is required to handle the given command.
        // We are able to search all application beans(class managed by spring) by type from the Spring ApplicationContext.
        final Class<?> commandType = command.getClass();
        final Class<OUT> responseType = (Class<OUT>) ((ParameterizedType) commandType.getGenericInterfaces()[0]).getActualTypeArguments()[0];

        // Retrieve RequestHandler beans based on command and response types.
        final String[] beanNames = this.abstractApplicationContext.getBeanNamesForType(ResolvableType.forClassWithGenerics(ICommandHandler.class, commandType, responseType));

        // There must be a registered handler.
        if (beanNames.length == 0) {
            throw new IllegalStateException("No handlers seemed to be registered to handle the given request. Make sure the handler is defined and marked as a spring component");
        }

        // There may not be more than one handler.
        if (beanNames.length > 1) {
            throw new IllegalStateException("More than one handlers found. Only one handler per request is allowed.");
        }

        final ICommandHandler<ICommand<OUT>, OUT> commandHandler = (ICommandHandler<ICommand<OUT>, OUT>) this.abstractApplicationContext.getBean(beanNames[0]);

        return commandHandler.handle(command);
    }
}
