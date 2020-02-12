package domain.zeno.core.persistence.db.schema.jdbc.action.column;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.persistence.db.generic.jdbc.IJdbcStatementBuilder;
import domain.zeno.core.persistence.db.schema.generic.model.Column;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcModifyColumnStatement implements IJdbcStatementBuilder {
    private static final String SQL_MODIFY_COLUMN = "ALTER TABLE %s MODIFY %s %s";

    private final String tableName;
    private final Column column;

    public JdbcModifyColumnStatement(String tableName, Column column) {
        this.tableName = tableName;
        this.column = column;
    }

    @Override
    public PreparedStatement build(Connection connection) {
        String definition = new JdbcColumnDefinitionBuilder().build(column);

        String query = SQL_MODIFY_COLUMN;
        query = String.format(query, tableName, column.getName(), definition);

        try {
            return connection.prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
