package com.cryoport.skytrax.resolver.resolvers;

import com.cryoport.skytrax.entity.DeviceEntity;
import com.cryoport.skytrax.repository.DeviceRepository;
import com.cryoport.skytrax.resolver.model.dto.Device;
import io.micronaut.core.util.CollectionUtils;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

@Singleton
public class DevicesResolver implements Resolver<List<DeviceEntity>> {

    private static final Logger LOG = LoggerFactory.getLogger(DevicesResolver.class);

    @Inject
    private DeviceRepository deviceRepository;

    @Override
    public List<DeviceEntity> resolve(Map<String, Object> event) {
        LOG.info("Starting Devices resolver");
        Iterable<DeviceEntity> devices = deviceRepository.findAll();
        return CollectionUtils.iterableToList(devices);
    }
}
