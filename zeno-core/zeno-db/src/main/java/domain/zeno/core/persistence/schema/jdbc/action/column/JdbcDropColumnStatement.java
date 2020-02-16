package domain.zeno.core.persistence.schema.jdbc.action.column;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.persistence.generic.jdbc.IJdbcStatementBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDropColumnStatement implements IJdbcStatementBuilder {
    private static final String SQL_DROP_COLUMN = "ALTER TABLE %s DROP COLUMN %s";

    private final String tableName;
    private final String columnName;

    public JdbcDropColumnStatement(String tableName, String columnName) {
        this.tableName = tableName;
        this.columnName = columnName;
    }

    @Override
    public PreparedStatement build(Connection connection) {
        String query = SQL_DROP_COLUMN;
        query = String.format(query, tableName, columnName);

        try {
            return connection.prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
