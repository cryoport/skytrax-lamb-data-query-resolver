package com.cryoport.skytrax.resolver.resolvers;

import com.cryoport.skytrax.resolver.model.dto.ResponseType;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

@Singleton
public class DevicesResolver implements Resolver<ResponseType.Devices> {

    private static final Logger LOG = LoggerFactory.getLogger(DevicesResolver.class);
    @Override
    public ResponseType.Devices resolve(Map<String, Object> event) {
        //TODO: implement
        LOG.info("Starting resolver");
        return new ResponseType.Devices(List.of(
                new ResponseType.Device("123", "some-message"),
                new ResponseType.Device("456", "some-message"),
                new ResponseType.Device("789", "some-message")));
    }
}
