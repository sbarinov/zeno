package domain.zeno.core.persistence.data.jdbc.action;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.persistence.generic.jdbc.IJdbcStatementBuilder;
import domain.zeno.core.persistence.schema.model.PrimaryKey;
import domain.zeno.core.persistence.schema.model.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.stream.Collectors;

public class JdbcSelectStatement implements IJdbcStatementBuilder {
    private static final String SQL_UPDATE = "SELECT * FROM %s WHERE %s";

    private final Table table;

    public JdbcSelectStatement(Table table) {
        this.table = table;
    }

    @Override
    public PreparedStatement build(Connection connection) {
        String where = null;

        PrimaryKey pk = table.getPrimaryKey();
        if (pk != null) {
            where = pk.getColumns().stream().map(c -> c + " = ?").collect(Collectors.joining(", "));
        }

        if (where == null || where.trim().isEmpty()) {
            where = "1=0";
        }

        String query = SQL_UPDATE;
        query = String.format(query, table.getName(), where);

        try {
            return connection.prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
