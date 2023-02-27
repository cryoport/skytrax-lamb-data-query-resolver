package com.cryoport.skytrax.resolver.resolvers;

import com.cryoport.skytrax.resolver.model.dto.Device;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

@Singleton
public class DevicesResolver implements Resolver<List<Device>> {

    private static final Logger LOG = LoggerFactory.getLogger(DevicesResolver.class);
    @Override
    public List<Device> resolve(Map<String, Object> event) {
        //TODO: implement
        LOG.info("Starting resolver");
        return List.of(
                new Device("123", "some-message"),
                new Device("456", "some-message"),
                new Device("789", "some-message"));
    }
}
