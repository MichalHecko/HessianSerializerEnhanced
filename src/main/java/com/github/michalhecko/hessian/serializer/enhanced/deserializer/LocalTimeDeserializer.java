package com.github.michalhecko.hessian.serializer.enhanced.deserializer;

import com.caucho.hessian.io.AbstractStringValueDeserializer;

import java.io.IOException;
import java.time.LocalTime;

public class LocalTimeDeserializer extends AbstractStringValueDeserializer {

    @Override
    public Class<?> getType() {
        return LocalTime.class;
    }

    @Override
    protected Object create(String value) throws IOException {
        return LocalTime.parse(value);
    }
}
