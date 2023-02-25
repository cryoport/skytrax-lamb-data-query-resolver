package com.cryoport.skytrax.resolver.model.dto;

import java.util.List;

public interface ResponseType {

    record Device(String id, String message) implements ResponseType {
    }

    record Devices(List<Device> devices) implements ResponseType {
    }

    record AlarmBandFilter(String name) implements ResponseType {
    }

    record AlarmBandFilters(List<AlarmBandFilter> alarmBandFilters) implements ResponseType {
    }

    record ConditionMonitorData(String deviceId, String someData) implements ResponseType {
    }
}
