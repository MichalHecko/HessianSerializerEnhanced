package com.github.michalhecko.hessian.serializer.enhanced;


import org.junit.jupiter.api.Test;
import com.github.michalhecko.hessian.serializer.enhanced.utils.HessianUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    @Test
    public void testLocalDate() throws Exception {
        LocalDate date = LocalDate.now();

        byte[] data = HessianUtils.serialize(date);
        assertEquals(date, HessianUtils.deserialize(data));
    }

    @Test
    public void testLocalTime() throws Exception {
        LocalTime dateTime = LocalTime.now();

        byte[] data = HessianUtils.serialize(dateTime);
        assertEquals(dateTime, HessianUtils.deserialize(data));
    }

    @Test
    public void testLocalDateTime() throws Exception {
        LocalDateTime dateTime = LocalDateTime.now();

        byte[] data = HessianUtils.serialize(dateTime);
        assertEquals(dateTime, HessianUtils.deserialize(data));
    }

    @Test
    public void testBigDecimal() throws Exception {
        BigDecimal number = new BigDecimal(999);

        byte[] data = HessianUtils.serialize(number);
        assertEquals(number, HessianUtils.deserialize(data));
    }

    @Test
    public void testZonedDateTime() throws Exception {
        final ZonedDateTime zonedDateTime = ZonedDateTime.now();

        byte[] data = HessianUtils.serialize(zonedDateTime);
        assertEquals(zonedDateTime, HessianUtils.deserialize(data));
    }

    @Test
    public void testLocale() throws Exception {
        final Locale locale = Locale.forLanguageTag("en");

        byte[] data = HessianUtils.serialize(locale);
        assertEquals(locale.getLanguage(), HessianUtils.deserialize(data));
    }
}
