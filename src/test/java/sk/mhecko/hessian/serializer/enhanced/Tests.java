package sk.mhecko.hessian.serializer.enhanced;


import org.junit.jupiter.api.Test;
import sk.mhecko.hessian.serializer.enhanced.utils.HessianUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
}
