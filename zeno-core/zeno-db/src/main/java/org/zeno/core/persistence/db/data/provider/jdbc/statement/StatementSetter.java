package org.zeno.core.persistence.db.data.provider.jdbc.statement;

import org.zeno.core.persistence.data.meta.FieldType;
import org.zeno.core.persistence.data.model.IValueContainer;

import java.io.ByteArrayInputStream;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

public class StatementSetter {
    private final PreparedStatement statement;
    private final AtomicInteger index = new AtomicInteger(1);

    public StatementSetter(PreparedStatement statement) {
        this.statement = statement;
    }

    public void set(IValueContainer value) throws SQLException {
        FieldType type = value.getType();

        if (type == null) {
            throw new IllegalArgumentException("Empty field type");
        }

        int n = index.incrementAndGet();

        switch (type) {
            case BYTE:
                statement.setBlob(n, new ByteArrayInputStream(value.getBytes()));
                break;
            case BOOLEAN:
                statement.setBoolean(n, value.getBoolean());
                break;
            case INTEGER:
                statement.setInt(n, value.getInteger());
                break;
            case LONG:
                statement.setLong(n, value.getLong());
                break;
            case DATE:
                statement.setDate(n, new Date(value.getDate().getTime()));
                break;
            case STRING:
            default:
                statement.setString(n, value.getString());
                break;
        }
    }
}
