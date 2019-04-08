package com.mhecko.hessian.serializer.enhanced.factory;

import com.caucho.hessian.io.AbstractSerializerFactory;
import com.caucho.hessian.io.Deserializer;
import com.caucho.hessian.io.Serializer;
import com.mhecko.hessian.serializer.enhanced.deserializer.LocalTimeDeserializer;
import com.mhecko.hessian.serializer.enhanced.serializer.LocalTimeSerializer;

import java.time.LocalTime;

public class LocalTimeSerializerFactory extends AbstractSerializerFactory {
    private Serializer serializer = new LocalTimeSerializer();
    private Deserializer deserializer = new LocalTimeDeserializer();

    @Override
    public Serializer getSerializer(Class cl) {
        if (LocalTime.class.isAssignableFrom(cl)) {
            return serializer;
        }

        return null;
    }

    @Override
    public Deserializer getDeserializer(Class cl) {
        if (LocalTime.class.isAssignableFrom(cl)) {
            return deserializer;
        }

        return null;
    }
}
