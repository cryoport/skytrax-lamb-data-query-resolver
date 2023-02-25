package com.cryoport.skytrax.resolver;

import io.micronaut.context.BeanContext;
import jakarta.inject.Singleton;

@Singleton
public class ResolverFactory {

    private final BeanContext beanContext;

    public ResolverFactory(BeanContext beanContext) {
        this.beanContext = beanContext;
    }

    public Resolver provideResolver(String fieldName) {
        FieldName fieldNameEnum = FieldName.get(fieldName);
        if (fieldNameEnum == null)
            throw new UnsupportedOperationException("Not a valid fieldName %s".formatted(fieldName));

        return switch (fieldNameEnum) {
            case DEVICES -> beanContext.getBean(DevicesResolver.class);
            case ALARM_BAND_FILTER -> beanContext.getBean(AlarmBandFilterResolver.class);
            case ALARM_BAND_FILTERS -> beanContext.getBean(AlarmBandFiltersResolver.class);
            case CONDITION_MONITOR_DATA -> beanContext.getBean(ConditionMonitorDataResolver.class);
        };

    }
}
