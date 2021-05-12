package com.mhecko.hessian.serializer.enhanced.factory;

import com.caucho.hessian.io.AbstractSerializerFactory;
import com.caucho.hessian.io.Deserializer;
import com.caucho.hessian.io.Serializer;
import com.mhecko.hessian.serializer.enhanced.deserializer.ZonedDateTimeDeserializer;
import com.mhecko.hessian.serializer.enhanced.serializer.ZonedDateTimeSerializer;

import java.time.ZonedDateTime;

public class ZonedDateTimeSerializerFactory extends AbstractSerializerFactory {

    private final Serializer serializer = new ZonedDateTimeSerializer();
    private final Deserializer deserializer = new ZonedDateTimeDeserializer();

    @Override
    public Serializer getSerializer(Class cl) {
        if (ZonedDateTime.class.isAssignableFrom(cl)) {
            return serializer;
        }

        return null;
    }

    @Override
    public Deserializer getDeserializer(Class cl) {
        if (ZonedDateTime.class.isAssignableFrom(cl)) {
            return deserializer;
        }

        return null;
    }
}