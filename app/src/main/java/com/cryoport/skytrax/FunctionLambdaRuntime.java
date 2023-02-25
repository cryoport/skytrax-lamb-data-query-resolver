package com.cryoport.skytrax;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import io.micronaut.function.aws.runtime.AbstractMicronautLambdaRuntime;

import java.net.MalformedURLException;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.micronaut.core.annotation.Nullable;

public class FunctionLambdaRuntime
        extends AbstractMicronautLambdaRuntime<
        Map<String, Object>, Map<String, Object>,
        Map<String, Object>, Map<String, Object>
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
    protected RequestHandler<Map<String, Object>, Map<String, Object>> createRequestHandler(String... args) {
        return new FunctionRequestHandler();
    }
}
