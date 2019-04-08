package com.mhecko.hessian.serializer.enhanced.deserializer;

import com.caucho.hessian.io.AbstractStringValueDeserializer;

import java.io.IOException;
import java.time.LocalDate;

public class LocalDateDeserializer extends AbstractStringValueDeserializer {

    @Override
    public Class<?> getType() {
        return LocalDate.class;
    }

    @Override
    protected Object create(String value) throws IOException {
        return LocalDate.parse(value);
    }
}
