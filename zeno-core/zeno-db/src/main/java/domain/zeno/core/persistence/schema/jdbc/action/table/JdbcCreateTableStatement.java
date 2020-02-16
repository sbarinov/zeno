package domain.zeno.core.persistence.schema.jdbc.action.table;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.persistence.generic.jdbc.IJdbcStatementBuilder;
import domain.zeno.core.persistence.schema.model.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcCreateTableStatement implements IJdbcStatementBuilder {
    private static final String SQL_CREATE_TABLE =
            "CREATE TABLE %s (SYS_VISIBLE NUMBER(1) DEFAULT 1)";
    private static final String SQL_CREATE_TABLE_TABLESPACE = SQL_CREATE_TABLE + " TABLESPACE %s";

    private final Table resource;

    public JdbcCreateTableStatement(Table resource) {
        this.resource = resource;
    }

    @Override
    public PreparedStatement build(Connection connection) {
        String query;
        if (resource.getTablespace() != null) {
            query = SQL_CREATE_TABLE_TABLESPACE;
            query = String.format(query, resource.getName(), resource.getTablespace());
        } else {
            query = SQL_CREATE_TABLE;
            query = String.format(query, resource.getName());
        }

        try {
            return connection.prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
