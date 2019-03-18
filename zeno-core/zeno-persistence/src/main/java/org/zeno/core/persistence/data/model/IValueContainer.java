package org.zeno.core.persistence.data.model;

import org.zeno.core.persistence.data.meta.FieldType;

import java.util.Date;

public interface IValueContainer {
    FieldType getType();

    String getString();

    Integer getInteger();

    Long getLong();

    Boolean getBoolean();

    byte[] getBytes();

    Date getDate();
}
