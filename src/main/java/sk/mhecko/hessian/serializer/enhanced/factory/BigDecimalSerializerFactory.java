package sk.mhecko.hessian.serializer.enhanced.factory;

import com.caucho.hessian.io.AbstractSerializerFactory;
import com.caucho.hessian.io.Deserializer;
import com.caucho.hessian.io.HessianProtocolException;
import com.caucho.hessian.io.Serializer;
import sk.mhecko.hessian.serializer.enhanced.deserializer.BigDecimalDeserializer;
import sk.mhecko.hessian.serializer.enhanced.serializer.BigDecimalSerializer;

import java.math.BigDecimal;

public class BigDecimalSerializerFactory extends AbstractSerializerFactory {
    private Serializer bigDecimalSerializer = new BigDecimalSerializer();
    private Deserializer bigDecimalDeserializer = new BigDecimalDeserializer();

    @Override
    public Serializer getSerializer(Class cl) throws HessianProtocolException {
        if (BigDecimal.class.isAssignableFrom(cl)) {
            return bigDecimalSerializer;
        }
        return null;
    }

    @Override
    public Deserializer getDeserializer(Class cl) throws HessianProtocolException {
        if (BigDecimal.class.isAssignableFrom(cl)) {
            return bigDecimalDeserializer;
        }
        return null;
    }
}
