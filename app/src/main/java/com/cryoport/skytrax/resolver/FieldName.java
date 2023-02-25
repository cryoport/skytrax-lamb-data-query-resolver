package com.cryoport.skytrax.resolver;

import javax.annotation.CheckForNull;
import java.util.HashMap;
import java.util.Map;

public enum FieldName {

    ALARM_BAND_FILTER("alarmBandFilter"),
    ALARM_BAND_FILTERS("alarmBandFilters"),
    DEVICES("devices"),
    CONDITION_MONITOR_DATA("conditionMonitorData");

    private static final Map<String, FieldName> map = new HashMap<>();
    private final String value;

    FieldName(String value) {
        this.value = value;
    }

    private static void init() {
        for (FieldName fieldName : FieldName.values()) {
            map.put(fieldName.value, fieldName);
        }
        assert map.size() == FieldName.values().length;
    }

    @CheckForNull
    public static FieldName get(String fieldName) {
        if (map.isEmpty()) init();
        return map.get(fieldName);
    }
}
