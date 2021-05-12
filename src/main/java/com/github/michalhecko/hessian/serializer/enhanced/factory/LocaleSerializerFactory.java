package com.github.michalhecko.hessian.serializer.enhanced.factory;

import com.caucho.hessian.io.AbstractSerializerFactory;
import com.caucho.hessian.io.Deserializer;
import com.caucho.hessian.io.Serializer;
import com.github.michalhecko.hessian.serializer.enhanced.deserializer.LocaleDeserializer;
import com.github.michalhecko.hessian.serializer.enhanced.serializer.LocaleSerializer;

import java.util.Locale;

public class LocaleSerializerFactory extends AbstractSerializerFactory {

    private final Serializer serializer = new LocaleSerializer();
    private final Deserializer deserializer = new LocaleDeserializer();

    @Override
    public Serializer getSerializer(Class cl) {
        if (Locale.class.isAssignableFrom(cl)) {
            return serializer;
        }

        return null;
    }

    @Override
    public Deserializer getDeserializer(Class cl) {
        if (Locale.class.isAssignableFrom(cl)) {
            return deserializer;
        }

        return null;
    }

}
