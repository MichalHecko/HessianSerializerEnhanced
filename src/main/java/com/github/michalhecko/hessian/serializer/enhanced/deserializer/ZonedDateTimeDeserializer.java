package com.github.michalhecko.hessian.serializer.enhanced.deserializer;

import com.caucho.hessian.io.AbstractStringValueDeserializer;

import java.time.ZonedDateTime;

public class ZonedDateTimeDeserializer extends AbstractStringValueDeserializer {

    @Override
    public Class<?> getType() {
        return ZonedDateTime.class;
    }

    @Override
    protected Object create(String value) {
        return ZonedDateTime.parse(value);
    }
}
