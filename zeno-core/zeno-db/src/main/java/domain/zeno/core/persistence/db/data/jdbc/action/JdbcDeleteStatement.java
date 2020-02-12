package domain.zeno.core.persistence.db.data.jdbc.action;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.persistence.db.generic.jdbc.IJdbcStatementBuilder;
import domain.zeno.core.persistence.db.schema.generic.model.PrimaryKey;
import domain.zeno.core.persistence.db.schema.generic.model.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.stream.Collectors;

public class JdbcDeleteStatement implements IJdbcStatementBuilder {
    private static final String SQL_DELETE = "DELETE FROM %s WHERE %s";

    private final Table table;

    public JdbcDeleteStatement(Table table) {
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

        String query = SQL_DELETE;
        query = String.format(query, table.getName(), where);

        try {
            return connection.prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
