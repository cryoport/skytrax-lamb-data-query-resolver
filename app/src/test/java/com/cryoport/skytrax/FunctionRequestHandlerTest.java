package com.cryoport.skytrax;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.core.io.ResourceResolver;
import jakarta.inject.Inject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class FunctionRequestHandlerTest extends BaseMongoDataTest {

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
    void testHandler() throws IOException {
        var expectedPayload =
                mapper.readValue(resourceResolver.getResource("classpath:event.json").get(), Map.class);
        Object execute = handler.execute(expectedPayload);
        assertNotNull(execute);
    }
}
