package com.cryoport.skytrax.resolver.resolvers;

import com.cryoport.skytrax.entity.ConditionMonitorDataEntity;
import com.cryoport.skytrax.repository.DataRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@Singleton
public class ConditionMonitorDataResolver implements Resolver<List<ConditionMonitorDataEntity>> {

    private static final Logger LOG = LoggerFactory.getLogger(ConditionMonitorDataResolver.class);

    @Inject
    private DataRepository dataRepository;

    @Override
    public List<ConditionMonitorDataEntity> resolve(Map<String, Object> event) {
        LOG.info("Starting ConditionMonitorData resolver");
        Map<String, Object> arguments = (Map<String, Object>) event.get("arguments");
        String name = arguments.get("deviceId").toString();
        Instant startDate = Instant.parse(arguments.get("startDate").toString());
        Instant endDate = Instant.parse(arguments.get("endDate").toString());
        return dataRepository.findByDeviceIdAndTimestampBetween(name, startDate, endDate);
    }
}
