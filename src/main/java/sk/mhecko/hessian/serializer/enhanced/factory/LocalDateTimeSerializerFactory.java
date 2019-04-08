package sk.mhecko.hessian.serializer.enhanced.factory;

import com.caucho.hessian.io.AbstractSerializerFactory;
import com.caucho.hessian.io.Deserializer;
import com.caucho.hessian.io.Serializer;
import sk.mhecko.hessian.serializer.enhanced.deserializer.LocalDateTimeDeserializer;
import sk.mhecko.hessian.serializer.enhanced.serializer.LocalDateTimeSerializer;

import java.time.LocalDateTime;

public class LocalDateTimeSerializerFactory extends AbstractSerializerFactory {
    private Serializer serializer = new LocalDateTimeSerializer();
    private Deserializer deserializer = new LocalDateTimeDeserializer();

    @Override
    public Serializer getSerializer(Class cl) {
        if (LocalDateTime.class.isAssignableFrom(cl)) {
            return serializer;
        }

        return null;
    }

    @Override
    public Deserializer getDeserializer(Class cl) {
        if (LocalDateTime.class.isAssignableFrom(cl)) {
            return deserializer;
        }

        return null;
    }
}