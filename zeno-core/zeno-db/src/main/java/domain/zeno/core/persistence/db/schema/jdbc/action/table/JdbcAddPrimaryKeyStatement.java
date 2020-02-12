package domain.zeno.core.persistence.db.schema.jdbc.action.table;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.persistence.db.schema.generic.model.PrimaryKey;
import domain.zeno.core.persistence.db.generic.jdbc.IJdbcStatementBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcAddPrimaryKeyStatement implements IJdbcStatementBuilder {
    private static final String SQL_ADD_PRIMARY_KEY =
            "ALTER TABLE %s ADD CONSTRAINT %s PRIMARY KEY(%s)";

    private final String tableName;
    private final PrimaryKey primaryKey;

    public JdbcAddPrimaryKeyStatement(String tableName, PrimaryKey primaryKey) {
        this.tableName = tableName;
        this.primaryKey = primaryKey;
    }

    @Override
    public PreparedStatement build(Connection connection) {
        String query = SQL_ADD_PRIMARY_KEY;

        query = String.format(query, tableName, primaryKey.getName(),
                String.join(", ", primaryKey.getColumns()));

        try {
            return connection.prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
