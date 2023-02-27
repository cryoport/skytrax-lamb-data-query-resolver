package com.cryoport.skytrax.resolver.resolvers;


import com.cryoport.skytrax.resolver.model.dto.AlarmBandFilter;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Map;

@Singleton
public class AlarmBandFiltersResolver implements Resolver<List<AlarmBandFilter>> {
    @Override
    public List<AlarmBandFilter> resolve(Map<String, Object> event) {
        //TODO: implement
        throw new UnsupportedOperationException("pending to implement");
    }
}
