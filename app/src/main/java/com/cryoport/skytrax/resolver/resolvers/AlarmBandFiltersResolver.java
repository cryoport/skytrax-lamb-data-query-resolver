package com.cryoport.skytrax.resolver.resolvers;


import com.cryoport.skytrax.entity.AlarmBandFiltersEntity;
import com.cryoport.skytrax.repository.AlarmBandFiltersRepository;
import io.micronaut.core.util.CollectionUtils;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

@Singleton
public class AlarmBandFiltersResolver implements Resolver<List<AlarmBandFiltersEntity>> {

    private static final Logger LOG = LoggerFactory.getLogger(AlarmBandFiltersResolver.class);

    @Inject
    private AlarmBandFiltersRepository alarmBandFiltersRepository;

    @Override
    public List<AlarmBandFiltersEntity> resolve(Map<String, Object> event) {
        LOG.info("Starting AlarmBandFilters resolver");
        Iterable<AlarmBandFiltersEntity> alarmBandFilters = alarmBandFiltersRepository.findAll();
        return CollectionUtils.iterableToList(alarmBandFilters);
    }
}
