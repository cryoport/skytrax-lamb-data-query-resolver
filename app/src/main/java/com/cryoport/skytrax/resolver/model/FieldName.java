package com.cryoport.skytrax.resolver.model;

import javax.annotation.CheckForNull;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum FieldName {

    ALARM_BAND_FILTER("alarmBandFilter"),
    ALARM_BAND_FILTERS("alarmBandFilters"),
    DEVICES("devices"),
    CONDITION_MONITOR_DATA("conditionMonitorData");

    private static final Map<String, FieldName> map = Arrays.stream(FieldName.values())
            .collect(Collectors.toMap(FieldName::getValue, Function.identity()));
    private final String value;

    FieldName(String value) {
        this.value = value;
    }

    private String getValue() {
        return value;
    }

    @CheckForNull
    public static FieldName get(String fieldName) {
        return map.get(fieldName);
    }
}
