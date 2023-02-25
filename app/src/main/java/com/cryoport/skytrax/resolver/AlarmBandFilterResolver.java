package com.cryoport.skytrax.resolver;

import com.cryoport.skytrax.resolver.dto.DeviceDto;
import com.cryoport.skytrax.resolver.dto.ResponseType;
import jakarta.inject.Singleton;

import java.util.Map;

@Singleton
public class AlarmBandFilterResolver implements Resolver {
    @Override
    public <T extends ResponseType> T resolve(Map<String, Object> event) {
        @SuppressWarnings("unchecked")
        T result = (T) new DeviceDto("123", "hi");
        return result;
    }
}
