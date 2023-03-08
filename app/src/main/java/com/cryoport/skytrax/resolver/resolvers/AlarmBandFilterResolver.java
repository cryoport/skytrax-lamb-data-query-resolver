package com.cryoport.skytrax.resolver.resolvers;

import com.cryoport.skytrax.entity.AlarmBandFiltersEntity;
import com.cryoport.skytrax.repository.AlarmBandFiltersRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Optional;

@Singleton
public class AlarmBandFilterResolver implements Resolver<Optional<AlarmBandFiltersEntity>> {

    private static final Logger LOG = LoggerFactory.getLogger(AlarmBandFilterResolver.class);

    @Inject
    private AlarmBandFiltersRepository alarmBandFiltersRepository;

    @Override
    public Optional<AlarmBandFiltersEntity> resolve(Map<String, Object> event) {
        LOG.info("Starting AlarmBandFilter resolver");
        Map<String, Object> arguments = (Map<String, Object>) event.get("arguments");
        String name = arguments.get("name").toString();
        return alarmBandFiltersRepository.findByName(name);
    }
}
