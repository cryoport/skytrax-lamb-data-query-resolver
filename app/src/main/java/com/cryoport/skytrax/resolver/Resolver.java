package com.cryoport.skytrax.resolver;

import com.cryoport.skytrax.resolver.dto.ResponseType;

import java.util.Map;

public interface Resolver {

    <T extends ResponseType> T resolve(Map<String, Object> event);

}
