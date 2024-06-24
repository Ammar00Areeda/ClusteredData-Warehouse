package com.Bloomberg.Warehouse.util;

import lombok.experimental.UtilityClass;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@UtilityClass
public class DateUtils {
    public OffsetDateTime offsetDateTimeNowUtc() {
        return Instant.now().atOffset(ZoneOffset.UTC);
    }
}
