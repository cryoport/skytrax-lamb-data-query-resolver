package com.cryoport.skytrax;

import com.cryoport.skytrax.resolver.model.FieldName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldNameTest {

    @Test
    void verify_enum_get() {
        FieldName value = FieldName.get("conditionMonitorData");
        assertNotNull(value);
        assertEquals(FieldName.CONDITION_MONITOR_DATA, value);

        value = FieldName.get("notAValue");
        assertNull(value);
    }
}
