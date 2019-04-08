package sk.mhecko.hessian.serializer.enhanced;

import com.caucho.hessian.io.AbstractSerializerFactory;
import com.caucho.hessian.io.Deserializer;
import com.caucho.hessian.io.HessianProtocolException;
import com.caucho.hessian.io.Serializer;
import sk.mhecko.hessian.serializer.enhanced.deserializer.LocalDateDeserializer;
import sk.mhecko.hessian.serializer.enhanced.deserializer.LocalDateTimeDeserializer;
import sk.mhecko.hessian.serializer.enhanced.deserializer.LocalTimeDeserializer;
import sk.mhecko.hessian.serializer.enhanced.serializer.LocalDateSerializer;
import sk.mhecko.hessian.serializer.enhanced.serializer.LocalDateTimeSerializer;
import sk.mhecko.hessian.serializer.enhanced.serializer.LocalTimeSerializer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class EnhancedSerializerFactory extends AbstractSerializerFactory {
    @Override
    public Serializer getSerializer(Class cl) throws HessianProtocolException {
        if (LocalDate.class.isAssignableFrom(cl)) {
            return new LocalDateSerializer();
        }
        if (LocalTime.class.isAssignableFrom(cl)) {
            return new LocalTimeSerializer();
        }
        if (LocalDateTime.class.isAssignableFrom(cl)) {
            return new LocalDateTimeSerializer();
        }

        return null;
    }

    @Override
    public Deserializer getDeserializer(Class cl) throws HessianProtocolException {
        if (LocalDate.class.isAssignableFrom(cl)) {
            return new LocalDateDeserializer();
        }
        if (LocalTime.class.isAssignableFrom(cl)) {
            return new LocalTimeDeserializer();
        }
        if (LocalDateTime.class.isAssignableFrom(cl)) {
            return new LocalDateTimeDeserializer();
        }

        return null;
    }
}
