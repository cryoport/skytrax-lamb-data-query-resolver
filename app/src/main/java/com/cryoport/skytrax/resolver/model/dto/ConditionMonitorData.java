package com.cryoport.skytrax.resolver.model.dto;

import io.micronaut.core.annotation.Introspected;

@Introspected
public record ConditionMonitorData(String deviceId, String someData) {
}
