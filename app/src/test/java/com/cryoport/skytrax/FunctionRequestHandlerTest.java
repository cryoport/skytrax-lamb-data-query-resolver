package com.cryoport.skytrax;

import com.cryoport.skytrax.dto.SensorData;
import com.cryoport.skytrax.entity.AlarmBandFiltersEntity;
import com.cryoport.skytrax.entity.ConditionMonitorDataEntity;
import com.cryoport.skytrax.entity.DeviceEntity;
import com.cryoport.skytrax.repository.AlarmBandFiltersRepository;
import com.cryoport.skytrax.repository.DataRepository;
import com.cryoport.skytrax.repository.DeviceRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.core.io.ResourceResolver;
import jakarta.inject.Inject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FunctionRequestHandlerTest extends BaseMongoDataTest {

    private static FunctionRequestHandler handler;

    @BeforeAll
    void setupServer() {
        handler = new FunctionRequestHandler(application.getApplicationContext());
    }

    @AfterAll
    public static void stopServer() {
        if (handler != null) {
            handler.getApplicationContext().close();
        }
    }

    @Inject
    private ObjectMapper mapper;

    @Inject
    private ResourceResolver resourceResolver;

    @Inject
    private DeviceRepository deviceRepository;

    @Inject
    private DataRepository dataRepository;

    @Inject
    private AlarmBandFiltersRepository alarmBandFiltersRepository;

    @ParameterizedTest
    @MethodSource("argumentsForValidRequest")
    void test_handler(Map<String, Object> event) {
        createDevice();
        createConditionMonitor();
        createAlarmBandFilters();
        Object execute = handler.execute(event);
        assertNotNull(execute);
    }

    @ParameterizedTest
    @MethodSource("argumentsForInValidRequest")
    void test_handler_invalid_payload(Map<String, Object> event) {
        createDevice();
        createConditionMonitor();
        assertThrows(UnsupportedOperationException.class, ()-> handler.execute(event));
    }

    Stream<Arguments> argumentsForValidRequest() throws IOException {
        var devicesEvent =
                mapper.readValue(resourceResolver.getResource("classpath:events/event-devices.json").get(), Map.class);
        var conditionMonitorDataEvent =
                mapper.readValue(resourceResolver.getResource("classpath:events/event-condition-monitor-data.json").get(), Map.class);
        var alarmBandFilterEvent =
                mapper.readValue(resourceResolver.getResource("classpath:events/event-alarm-band-filter.json").get(), Map.class);
        var alarmBandFiltersEvent =
                mapper.readValue(resourceResolver.getResource("classpath:events/event-alarm-band-filters.json").get(), Map.class);
        return Stream.of(
                Arguments.of(devicesEvent),
                Arguments.of(conditionMonitorDataEvent),
                Arguments.of(alarmBandFilterEvent),
                Arguments.of(alarmBandFiltersEvent)
        );
    }

    Stream<Arguments> argumentsForInValidRequest() throws IOException {
        var devicesEvent =
                mapper.readValue(resourceResolver.getResource("classpath:events/invalid-event-devices.json").get(), Map.class);
        var conditionMonitorDataEvent =
                mapper.readValue(resourceResolver.getResource("classpath:events/invalid-event-condition-monitor-data.json").get(), Map.class);
        return Stream.of(
                Arguments.of(devicesEvent),
                Arguments.of(conditionMonitorDataEvent)
        );
    }

    void createDevice() {
        DeviceEntity device = new DeviceEntity();
        device.setDeviceId("8627710408889999");
        device.setDeviceModel("SKYTRAX");
        device.setCreatedBy("ClientID");
        device.setCreatedDate(LocalDateTime.now());
        deviceRepository.save(device);
    }

    public void createConditionMonitor() {
        ConditionMonitorDataEntity conditionMonitorData = new ConditionMonitorDataEntity();
        conditionMonitorData.setSchemaVer(1);
        conditionMonitorData.setDeviceId("8627710409503815");
        conditionMonitorData.setTimestamp(Instant.parse("2022-11-03T10:37:30.00Z"));
        SensorData sensorData = new SensorData();
        sensorData.setTimestamp(Instant.parse("2022-11-03T10:37:30.00Z"));
        sensorData.setTagId("TAG123");
        conditionMonitorData.setSensorData(sensorData);
        dataRepository.save(conditionMonitorData);
    }

    public void createAlarmBandFilters() {
        AlarmBandFiltersEntity alarmBandFilters = new AlarmBandFiltersEntity();
        alarmBandFilters.setName("cryo_temp_between_-200_and_-150");
        alarmBandFilters.setDisplayString("Cryo Op Range Exceeded (-200° C to -150° C)");
        alarmBandFilters.setDisplayString1("Cryo");
        alarmBandFilters.setDisplayString2("Op Range Exceeded");
        alarmBandFilters.setDisplayString3("(-200° C to -150° C)");
        alarmBandFilters.setNumber1(-159);
        alarmBandFilters.setNumber2(-91);
        alarmBandFiltersRepository.save(alarmBandFilters);
    }


}
