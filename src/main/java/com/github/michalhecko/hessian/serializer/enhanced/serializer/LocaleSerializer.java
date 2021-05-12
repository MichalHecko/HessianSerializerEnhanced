package com.github.michalhecko.hessian.serializer.enhanced.serializer;

import com.caucho.hessian.io.AbstractHessianOutput;
import com.caucho.hessian.io.AbstractSerializer;

import java.io.IOException;
import java.util.Locale;

public class LocaleSerializer extends AbstractSerializer {

    @Override
    public void writeObject(Object object, AbstractHessianOutput out) throws IOException {
        if (object == null) {
            out.writeNull();
            return;
        }

        final Locale locale = (Locale) object;

        out.writeObject(locale.getLanguage());
    }
}
