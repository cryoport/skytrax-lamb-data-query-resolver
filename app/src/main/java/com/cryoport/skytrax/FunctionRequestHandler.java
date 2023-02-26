package com.cryoport.skytrax;

import com.cryoport.skytrax.resolver.model.dto.ResponseType;
import com.cryoport.skytrax.resolver.resolvers.Resolver;
import com.cryoport.skytrax.resolver.ResolverFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.context.ApplicationContext;
import io.micronaut.function.aws.MicronautRequestHandler;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


public class FunctionRequestHandler extends MicronautRequestHandler<Map<String, Object>, ResponseType<?>> {

    private static final Logger LOG = LoggerFactory.getLogger(FunctionRequestHandler.class);
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
        LOG.info("Start execution");
        Map<String, Object> info = (Map<String, Object>) event.get("info");
        String fieldName = info.get("fieldName").toString();
        Resolver<?> resolver = resolverFactory.provideResolver(fieldName);
        ResponseType<?> resolve = resolver.resolve(event);
        LOG.info("End execution");
        return resolve;
    }
}
