package org.zeno.core.persistence.db.data.provider.jdbc.resultset;

import org.zeno.core.bean.accessor.IDataAccessor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StringDataAccessor implements IDataAccessor<ResultSet, String> {
    private final String name;

    public StringDataAccessor(String name) {
        this.name = name;
    }

    @Override
    public String getData(ResultSet source) {
        try {
            return source.getString(name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
