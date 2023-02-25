package com.cryoport.skytrax;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.core.io.ResourceResolver;
import jakarta.inject.Inject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionRequestHandlerTest extends BaseMongoDataTest {

    private static FunctionRequestHandler handler;

    @BeforeAll
    void setupServer() {
        handler = new FunctionRequestHandler(application.getApplicationContext());
    }

    @AfterAll
    public static void stopServer() {
        if (handler != null) {
            handler.getApplicationContext().close();
        }
    }

    @Inject
    private ObjectMapper mapper;

    @Inject
    private ResourceResolver resourceResolver;

    @Test
    public void testHandler() throws IOException {
        var expectedPayload =
                mapper.readValue(resourceResolver.getResource("classpath:event.json").get(), Map.class);
        Map<String, Object> response = handler.execute(expectedPayload);
        assertEquals("Hello world", response.get("message"));
    }
}
