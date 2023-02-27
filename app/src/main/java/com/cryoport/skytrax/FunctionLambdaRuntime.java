package com.cryoport.skytrax;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.function.aws.runtime.AbstractMicronautLambdaRuntime;

import java.net.MalformedURLException;
import java.util.Map;

public class FunctionLambdaRuntime
        extends AbstractMicronautLambdaRuntime<
        Map<String, Object>, Object,
        Map<String, Object>, Object
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
    protected RequestHandler<Map<String, Object>, Object> createRequestHandler(String... args) {
        return new FunctionRequestHandler();
    }
}
