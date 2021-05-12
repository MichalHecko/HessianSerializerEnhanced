package com.github.michalhecko.hessian.serializer.enhanced.deserializer;

import com.caucho.hessian.io.AbstractStringValueDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;

public class LocalDateTimeDeserializer extends AbstractStringValueDeserializer {

    @Override
    public Class<?> getType() {
        return LocalDateTime.class;
    }

    @Override
    protected Object create(String value) throws IOException {
        return LocalDateTime.parse(value);
    }
}
