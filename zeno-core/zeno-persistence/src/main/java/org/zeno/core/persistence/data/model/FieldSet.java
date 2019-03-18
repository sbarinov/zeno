package org.zeno.core.persistence.data.model;

import org.zeno.core.persistence.data.meta.FieldMetaData;

import java.util.HashMap;
import java.util.Map;

public class FieldSet extends HashMap<FieldMetaData, IValueContainer> {
    public FieldSet() {
        super();
    }

    public FieldSet(Map<? extends FieldMetaData, ? extends IValueContainer> delegate) {
        super(delegate);
    }
}
