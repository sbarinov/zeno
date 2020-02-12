package domain.zeno.core.persistence.db.data.generic.model;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValueContainer {
    private Object value;

    public ValueContainer(Object value) {
        this.value = value;
    }

    public String getString() {
        if (value == null) {
            return null;
        }

        if (value instanceof String) {
            return (String) value;
        } else {
            return value.toString();
        }
    }

    public Integer getInteger() {
        if (value == null) {
            return null;
        }

        if (value instanceof Number) {
            return ((Number) value).intValue();
        } else if (value instanceof String) {
            return Integer.parseInt((String) value);
        } else {
            return null;
        }
    }

    public Long getLong() {
        if (value == null) {
            return null;
        }

        if (value instanceof Number) {
            return ((Number) value).longValue();
        } else if (value instanceof String) {
            return Long.getLong((String) value);
        } else {
            return null;
        }
    }

    public BigDecimal getBigDecimal() {
        if (value == null) {
            return null;
        }

        if (value instanceof Number) {
            return BigDecimal.valueOf(((Number) value).longValue());
        } else if (value instanceof String) {
            return new BigDecimal((String) value);
        } else {
            return null;
        }
    }

    public Date getDate() {
        if (value == null) {
            return null;
        }

        if (value instanceof Date) {
            return new Date(((Date) value).getTime());
        } else if (value instanceof Number) {
            return new Date(((Number) value).longValue());
        } else if (value instanceof String) {
            try {
                return new SimpleDateFormat().parse((String) value);
            } catch (ParseException ignored) {
                return null;
            }
        } else {
            return null;
        }
    }
}
