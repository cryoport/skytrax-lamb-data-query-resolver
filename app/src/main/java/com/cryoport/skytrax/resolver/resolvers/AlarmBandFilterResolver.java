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
public class AlarmBandFilterResolver implements Resolver<AlarmBandFiltersEntity> {

    private static final Logger LOG = LoggerFactory.getLogger(AlarmBandFilterResolver.class);

    @Inject
    private AlarmBandFiltersRepository alarmBandFiltersRepository;

    @Override
    public AlarmBandFiltersEntity resolve(Map<String, Object> event) {
        LOG.info("Starting AlarmBandFilter resolver");
        Map<String, Object> arguments = (Map<String, Object>) event.get("arguments");
        String name = arguments.get("name").toString();
        Optional<AlarmBandFiltersEntity> alarmBandFilter = alarmBandFiltersRepository.findByName(name);
        if (alarmBandFilter.isPresent()) {
            return alarmBandFilter.get();
        }
        return new AlarmBandFiltersEntity();
    }
}
