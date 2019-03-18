package org.zeno.core.persistence.db.data.query.jdbc;

import org.zeno.core.persistence.data.meta.ObjectMetaData;
import org.zeno.core.persistence.data.model.FieldSet;
import org.zeno.core.persistence.db.data.query.IFetchQueryBuilder;

public class JdbcSelectQueryBuilder implements IFetchQueryBuilder {
    private final ObjectMetaData objectMetaData;

    public JdbcSelectQueryBuilder(ObjectMetaData objectMetaData) {
        this.objectMetaData = objectMetaData;
    }

    @Override
    public String build(FieldSet fieldSet) {
        if (objectMetaData.getFieldMetaData().containsAll(fieldSet.keySet())) {
            throw new IllegalArgumentException("Metadata mismatch");
        }

        return null;
    }
}
