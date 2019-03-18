package org.zeno.core.persistence.data.meta;

import java.util.ArrayList;
import java.util.List;

public class PrimaryKeyMetaData {
    private final List<FieldMetaData> fields = new ArrayList<>();

    public PrimaryKeyMetaData(List<FieldMetaData> fields) {
        this.fields.addAll(fields);
    }

    public List<FieldMetaData> getFields() {
        return new ArrayList<>(fields);
    }
}
