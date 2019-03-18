package org.zeno.core.persistence.db.data.provider.jdbc.resultset;

import org.zeno.core.bean.accessor.IDataAccessor;
import org.zeno.core.persistence.data.meta.FieldMetaData;

import java.sql.ResultSet;

public class ResultSetFieldAccessor implements IDataAccessor<ResultSet, Object> {
    private FieldMetaData metaData;

    public ResultSetFieldAccessor(FieldMetaData metaData) {
        this.metaData = metaData;
    }

    @Override
    public Object getData(ResultSet source) {
        if (source == null) {
            return null;
        }

        // todo

        return null;
    }
}
