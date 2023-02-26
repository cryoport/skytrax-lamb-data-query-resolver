package com.cryoport.skytrax.resolver.model.dto;

import io.micronaut.core.annotation.Introspected;

import java.util.List;

public interface ResponseType<T> {

    @Introspected
    record Device(String id, String message) implements ResponseType<Device> {
    }

    @Introspected
    record Devices(List<Device> devices) implements ResponseType<Devices> {
    }

    @Introspected
    record AlarmBandFilter(String name) implements ResponseType<AlarmBandFilter> {
    }

    @Introspected
    record AlarmBandFilters(List<AlarmBandFilter> alarmBandFilters) implements ResponseType<AlarmBandFilters> {
    }
    @Introspected
    record ConditionMonitorData(String deviceId, String someData) implements ResponseType<ConditionMonitorData> {
    }
}
