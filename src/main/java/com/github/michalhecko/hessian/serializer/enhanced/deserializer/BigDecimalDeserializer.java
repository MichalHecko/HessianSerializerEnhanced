package com.github.michalhecko.hessian.serializer.enhanced.deserializer;

import com.caucho.hessian.io.AbstractStringValueDeserializer;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * http://stackoverflow.com/questions/11247239/bigdecimal-value-is-always-zero-when-transfered-with-spring-remoting-via-hessian
 */
public class BigDecimalDeserializer extends AbstractStringValueDeserializer {

    @Override
    public Class getType() {
        return BigDecimal.class;
    }

    @Override
    protected Object create(String value) {
        if (null != value) {
            try {
                // Locale specific formatting - always use EN
                DecimalFormat df = (DecimalFormat) NumberFormat.getNumberInstance(new Locale("en"));
                df.setParseBigDecimal(true);
                BigDecimal decimalValue = (BigDecimal) df.parse(value);
                return decimalValue;

            } catch (ParseException e) {
                return null;
            }
        } else {
            return null;
        }
    }
}
