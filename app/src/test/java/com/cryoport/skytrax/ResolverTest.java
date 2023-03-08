package com.cryoport.skytrax;

import com.cryoport.skytrax.resolver.resolvers.*;
import com.cryoport.skytrax.resolver.ResolverFactory;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class ResolverTest extends BaseMongoDataTest {

    @Inject
    ResolverFactory resolverFactory;

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
    @Test
    void test_devices_resolver_factory() {
        Resolver<?> resolver = resolverFactory.provideResolver("devices");
        assertNotNull(resolver);
        assertInstanceOf(DevicesResolver.class, resolver);
    }

    @Test
    void test_condition_monitor_data_resolver_factory() {
        Resolver<?> resolver = resolverFactory.provideResolver("conditionMonitorData");
        assertNotNull(resolver);
        assertInstanceOf(ConditionMonitorDataResolver.class, resolver);
    }

    @Test
    void test_alarm_band_filter_resolver_factory() {
        Resolver<?> resolver = resolverFactory.provideResolver("alarmBandFilter");
        assertNotNull(resolver);
        assertInstanceOf(AlarmBandFilterResolver.class, resolver);
    }

    @Test
    void test_alarm_band_filters_resolver_factory() {
        Resolver<?> resolver = resolverFactory.provideResolver("alarmBandFilters");
        assertNotNull(resolver);
        assertInstanceOf(AlarmBandFiltersResolver.class, resolver);
    }

    @Test
    void test_resolver_factory_throws_unsupported_exception() {
        assertThrows(UnsupportedOperationException.class, () -> resolverFactory.provideResolver("notValid"));
    }
}
