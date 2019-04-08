package sk.mhecko.hessian.serializer.enhanced;

import com.caucho.hessian.io.AbstractSerializerFactory;
import com.caucho.hessian.io.Deserializer;
import com.caucho.hessian.io.HessianProtocolException;
import com.caucho.hessian.io.Serializer;
import sk.mhecko.hessian.serializer.enhanced.factory.LocalDateSerializerFactory;
import sk.mhecko.hessian.serializer.enhanced.factory.LocalDateTimeSerializerFactory;
import sk.mhecko.hessian.serializer.enhanced.factory.LocalTimeSerializerFactory;

public class AllSerializerFactory extends AbstractSerializerFactory {
    private LocalDateSerializerFactory localDateSerializerFactory;
    private LocalDateTimeSerializerFactory localDateTimeSerializerFactory;
    private LocalTimeSerializerFactory localTimeSerializerFactory;

    public AllSerializerFactory() {
        this.localDateSerializerFactory = new LocalDateSerializerFactory();
        this.localDateTimeSerializerFactory = new LocalDateTimeSerializerFactory();
        this.localTimeSerializerFactory = new LocalTimeSerializerFactory();
    }

    @Override
    public Serializer getSerializer(Class cl) throws HessianProtocolException {
        return findFirstSerializer(cl,
                this.localDateSerializerFactory,
                this.localDateTimeSerializerFactory,
                this.localTimeSerializerFactory
        );
    }

    @Override
    public Deserializer getDeserializer(Class cl) throws HessianProtocolException {
        return findFirstDeserializer(cl,
                this.localDateSerializerFactory,
                this.localDateTimeSerializerFactory,
                this.localTimeSerializerFactory
        );
    }

    private Serializer findFirstSerializer(Class cl, AbstractSerializerFactory... serializerFactories) throws HessianProtocolException {
        Serializer serializer = null;
        for (AbstractSerializerFactory factory : serializerFactories) {
            serializer = factory.getSerializer(cl);
            if (serializer != null) {
                break;
            }
        }

        return serializer;
    }

    private Deserializer findFirstDeserializer(Class cl, AbstractSerializerFactory... serializerFactories) throws HessianProtocolException {
        Deserializer deserializer = null;
        for (AbstractSerializerFactory factory : serializerFactories) {
            deserializer = factory.getDeserializer(cl);
            if (deserializer != null) {
                break;
            }
        }

        return deserializer;
    }
}
