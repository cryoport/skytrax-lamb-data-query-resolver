package com.cryoport.skytrax.resolver;

import com.cryoport.skytrax.resolver.dto.ResponseType;
import jakarta.inject.Singleton;

import java.util.Map;

@Singleton
public class AlarmBandFiltersResolver implements Resolver {
    @Override
    public <T extends ResponseType> T resolve(Map<String, Object> event) {
        return null;
    }
}
