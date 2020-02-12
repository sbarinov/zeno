package domain.zeno.core.persistence.db.data.jdbc.action;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.persistence.db.data.generic.model.GenericRecord;
import domain.zeno.core.persistence.db.data.generic.model.ValueContainer;
import domain.zeno.core.persistence.db.generic.jdbc.IJdbcStatementBuilder;
import domain.zeno.core.persistence.db.schema.generic.model.Column;
import domain.zeno.core.persistence.db.schema.generic.model.ColumnType;
import domain.zeno.core.persistence.db.schema.generic.model.Table;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

public class JdbcRecordStatement implements IJdbcStatementBuilder {
    private final IJdbcStatementBuilder delegate;
    private final Table table;
    private final GenericRecord record;

    public JdbcRecordStatement(IJdbcStatementBuilder delegate, Table table, GenericRecord record) {
        this.delegate = delegate;
        this.table = table;
        this.record = record;
    }

    @Override
    public PreparedStatement build(Connection connection) {
        PreparedStatement statement = delegate.build(connection);

        Collection<Column> columns = table.getColumns();
        Map<String, ValueContainer> columnValues = record.getValues();

        int nIndex = 1;

        for (Column column : columns) {
            ValueContainer value = columnValues.get(column.getName());

            ColumnType columnType = column.getType();

            try {
                switch (columnType.getType()) {
                    case DATE:
                        statement.setDate(nIndex++, new Date(value.getDate().getTime()));
                        break;
                    case NUMBER:
                        statement.setLong(nIndex++, value.getLong());
                        break;
                    case BLOB:
                        // todo
                        break;
                    case CLOB:
                        // todo
                        break;
                    default:
                    case STRING:
                        statement.setString(nIndex++, value.getString());
                        break;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return statement;
    }
}
