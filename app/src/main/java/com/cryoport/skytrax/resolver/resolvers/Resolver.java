package com.cryoport.skytrax.resolver.resolvers;

import java.util.Map;

public interface Resolver<T> {

     T resolve(Map<String, Object> event);

}
