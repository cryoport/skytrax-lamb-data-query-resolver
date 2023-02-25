package com.cryoport.skytrax.resolver.resolvers;

import com.cryoport.skytrax.resolver.model.dto.ResponseType;

import java.util.Map;

public interface Resolver<T extends ResponseType> {

     T resolve(Map<String, Object> event);

}
