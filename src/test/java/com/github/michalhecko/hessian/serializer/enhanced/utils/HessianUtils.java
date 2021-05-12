package com.github.michalhecko.hessian.serializer.enhanced.utils;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.SerializerFactory;
import com.github.michalhecko.hessian.serializer.enhanced.AllSerializerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class HessianUtils {

    private static SerializerFactory create() {
        SerializerFactory serializerFactory = new SerializerFactory();
        serializerFactory.addFactory(new AllSerializerFactory());

        return serializerFactory;
    }

    public static Serializable deserialize(byte[] array) throws IOException {
        Object obj = null;
        ByteArrayInputStream bais = new ByteArrayInputStream(array);
        Hessian2Input hi = new Hessian2Input(bais);
        hi.setSerializerFactory(create());
        hi.setCloseStreamOnClose(true);
        hi.startMessage();
        obj = hi.readObject();
        hi.completeMessage();

        hi.close();
        return (Serializable) obj;
    }

    public static byte[] serialize(Object data) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Hessian2Output ho = new Hessian2Output(baos);
        ho.setSerializerFactory(create());
        ho.setCloseStreamOnClose(true);
        ho.startMessage();
        ho.writeObject(data);
        ho.completeMessage();

        ho.close();
        return baos.toByteArray();
    }
}
