package com.cryoport.skytrax;

import com.cryoport.skytrax.resolver.Resolver;
import com.cryoport.skytrax.resolver.ResolverFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.context.ApplicationContext;
import io.micronaut.function.aws.MicronautRequestHandler;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.Map;


public class FunctionRequestHandler extends MicronautRequestHandler<Map<String, Object>, Map<String, Object>> {
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
    public Map<String, Object> execute(Map<String, Object> event) {
        Map<String, Object> info = (Map<String, Object>) event.get("info");
        String fieldName = info.get("fieldName").toString();
        Resolver resolver = resolverFactory.provideResolver(fieldName);
        return resolver.resolve(event);
    }
}
