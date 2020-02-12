package domain.zeno.core.persistence.db.schema.jdbc.action.column;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.persistence.db.generic.jdbc.IJdbcStatementBuilder;
import domain.zeno.core.persistence.db.schema.generic.model.Column;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcAddColumnStatement implements IJdbcStatementBuilder {
    private static final String SQL_ADD_COLUMN = "ALTER TABLE %s ADD (%s %s)";

    private final String tableName;
    private final Column column;

    public JdbcAddColumnStatement(String tableName, Column column) {
        this.tableName = tableName;
        this.column = column;
    }

    @Override
    public PreparedStatement build(Connection connection) {
        String definition = new JdbcColumnDefinitionBuilder().build(column);

        String query = SQL_ADD_COLUMN;
        query = String.format(query, tableName, column.getName(), definition);

        try {
            return connection.prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
