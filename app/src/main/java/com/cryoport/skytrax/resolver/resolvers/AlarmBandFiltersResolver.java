package com.cryoport.skytrax.resolver.resolvers;


import com.cryoport.skytrax.resolver.model.dto.ResponseType;
import jakarta.inject.Singleton;

import java.util.Map;

@Singleton
public class AlarmBandFiltersResolver implements Resolver<ResponseType.AlarmBandFilter> {
    @Override
    public ResponseType.AlarmBandFilter resolve(Map<String, Object> event) {
        //TODO: implement
        throw new UnsupportedOperationException("pending to implement");
    }
}
