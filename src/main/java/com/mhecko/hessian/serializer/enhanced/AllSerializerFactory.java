package com.mhecko.hessian.serializer.enhanced;

import com.caucho.hessian.io.AbstractSerializerFactory;
import com.caucho.hessian.io.Deserializer;
import com.caucho.hessian.io.HessianProtocolException;
import com.caucho.hessian.io.Serializer;
import com.mhecko.hessian.serializer.enhanced.factory.*;

public class AllSerializerFactory extends AbstractSerializerFactory {

    private final LocalDateSerializerFactory localDateSerializerFactory;
    private final LocalDateTimeSerializerFactory localDateTimeSerializerFactory;
    private final LocalTimeSerializerFactory localTimeSerializerFactory;
    private final BigDecimalSerializerFactory bigDecimalSerializerFactory;
    private final ZonedDateTimeSerializerFactory zonedDateTimeSerializerFactory;
    private final LocaleSerializerFactory localeSerializerFactory;

    public AllSerializerFactory() {
        this.localDateSerializerFactory = new LocalDateSerializerFactory();
        this.localDateTimeSerializerFactory = new LocalDateTimeSerializerFactory();
        this.localTimeSerializerFactory = new LocalTimeSerializerFactory();
        this.bigDecimalSerializerFactory = new BigDecimalSerializerFactory();
        this.zonedDateTimeSerializerFactory = new ZonedDateTimeSerializerFactory();
        this.localeSerializerFactory = new LocaleSerializerFactory();
    }

    @Override
    public Serializer getSerializer(Class cl) throws HessianProtocolException {
        return findFirstSerializer(cl,
                this.localDateSerializerFactory,
                this.localDateTimeSerializerFactory,
                this.localTimeSerializerFactory,
                this.bigDecimalSerializerFactory,
                this.zonedDateTimeSerializerFactory,
                this.localeSerializerFactory
        );
    }

    @Override
    public Deserializer getDeserializer(Class cl) throws HessianProtocolException {
        return findFirstDeserializer(cl,
                this.localDateSerializerFactory,
                this.localDateTimeSerializerFactory,
                this.localTimeSerializerFactory,
                this.bigDecimalSerializerFactory,
                this.zonedDateTimeSerializerFactory,
                this.localeSerializerFactory
        );
    }

    private Serializer findFirstSerializer(Class<?> cl, AbstractSerializerFactory... serializerFactories) throws HessianProtocolException {
        Serializer serializer = null;
        for (AbstractSerializerFactory factory : serializerFactories) {
            serializer = factory.getSerializer(cl);
            if (serializer != null) {
                break;
            }
        }

        return serializer;
    }

    private Deserializer findFirstDeserializer(Class<?> cl, AbstractSerializerFactory... serializerFactories) throws HessianProtocolException {
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
