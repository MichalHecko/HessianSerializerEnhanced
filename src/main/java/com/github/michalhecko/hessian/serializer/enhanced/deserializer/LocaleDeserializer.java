package com.github.michalhecko.hessian.serializer.enhanced.deserializer;

import com.caucho.hessian.io.AbstractHessianInput;
import com.caucho.hessian.io.AbstractStringValueDeserializer;

import java.io.IOException;
import java.util.Locale;

public class LocaleDeserializer extends AbstractStringValueDeserializer {

    @Override
    public Class<?> getType() {
        return Locale.class;
    }

    @Override
    protected Object create(String value) {
        return Locale.forLanguageTag(value);
    }

    @Override
    public Object readObject(AbstractHessianInput in) throws IOException {
        return Locale.forLanguageTag(in.readString());
    }

}
