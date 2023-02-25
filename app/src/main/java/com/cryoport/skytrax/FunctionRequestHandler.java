package com.cryoport.skytrax;

import com.cryoport.skytrax.resolver.model.dto.ResponseType;
import com.cryoport.skytrax.resolver.resolvers.Resolver;
import com.cryoport.skytrax.resolver.ResolverFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.context.ApplicationContext;
import io.micronaut.function.aws.MicronautRequestHandler;
import jakarta.inject.Inject;

import java.util.Map;


public class FunctionRequestHandler extends MicronautRequestHandler<Map<String, Object>, ResponseType<?>> {
    @Inject
    ObjectMapper objectMapper;

    @Inject
    ResolverFactory resolverFactory;

    public FunctionRequestHandler() {
    }

    public FunctionRequestHandler(ApplicationContext applicationContext) {
        super(applicationContext);
    }

    @Override
    public ResponseType<?> execute(Map<String, Object> event) {
        Map<String, Object> info = (Map<String, Object>) event.get("info");
        String fieldName = info.get("fieldName").toString();
        Resolver<?> resolver = resolverFactory.provideResolver(fieldName);
        return resolver.resolve(event);
    }
}
