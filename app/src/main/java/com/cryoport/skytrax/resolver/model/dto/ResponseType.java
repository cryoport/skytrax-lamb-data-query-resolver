package com.cryoport.skytrax.resolver.model.dto;

import java.util.List;

public interface ResponseType<T> {

    record Device(String id, String message) implements ResponseType<Device> {
    }

    record Devices(List<Device> devices) implements ResponseType<Devices> {
    }

    record AlarmBandFilter(String name) implements ResponseType<AlarmBandFilter> {
    }

    record AlarmBandFilters(List<AlarmBandFilter> alarmBandFilters) implements ResponseType<AlarmBandFilters> {
    }

    record ConditionMonitorData(String deviceId, String someData) implements ResponseType {
    }
}
