package com.mhecko.hessian.serializer.enhanced.factory;

import com.caucho.hessian.io.AbstractSerializerFactory;
import com.caucho.hessian.io.Deserializer;
import com.caucho.hessian.io.Serializer;
import com.mhecko.hessian.serializer.enhanced.deserializer.LocalDateDeserializer;
import com.mhecko.hessian.serializer.enhanced.serializer.LocalDateSerializer;

import java.time.LocalDate;

public class LocalDateSerializerFactory extends AbstractSerializerFactory {
    private Serializer serializer = new LocalDateSerializer();
    private Deserializer deserializer = new LocalDateDeserializer();

    @Override
    public Serializer getSerializer(Class cl) {
        if (LocalDate.class.isAssignableFrom(cl)) {
            return serializer;
        }

        return null;
    }

    @Override
    public Deserializer getDeserializer(Class cl) {
        if (LocalDate.class.isAssignableFrom(cl)) {
            return deserializer;
        }

        return null;
    }
}
