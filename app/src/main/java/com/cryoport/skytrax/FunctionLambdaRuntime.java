package com.cryoport.skytrax;

import com.cryoport.skytrax.resolver.model.dto.ResponseType;
import io.micronaut.function.aws.runtime.AbstractMicronautLambdaRuntime;

import java.net.MalformedURLException;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.micronaut.core.annotation.Nullable;

public class FunctionLambdaRuntime
        extends AbstractMicronautLambdaRuntime<
        Map<String, Object>, ResponseType<?>,
        Map<String, Object>, ResponseType<?>
        > {
    public static void main(String[] args) {
        try {
            new FunctionLambdaRuntime().run(args);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Nullable
    protected RequestHandler<Map<String, Object>, ResponseType<?>> createRequestHandler(String... args) {
        return new FunctionRequestHandler();
    }
}
