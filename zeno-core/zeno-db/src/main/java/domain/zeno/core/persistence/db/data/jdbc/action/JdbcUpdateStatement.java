package domain.zeno.core.persistence.db.data.jdbc.action;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.persistence.db.generic.jdbc.IJdbcStatementBuilder;
import domain.zeno.core.persistence.db.schema.generic.model.Column;
import domain.zeno.core.persistence.db.schema.generic.model.PrimaryKey;
import domain.zeno.core.persistence.db.schema.generic.model.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.stream.Collectors;

public class JdbcUpdateStatement implements IJdbcStatementBuilder {
    private static final String SQL_UPDATE = "UPDATE %s SET %s WHERE %s";

    private final Table table;

    public JdbcUpdateStatement(Table table) {
        this.table = table;
    }

    @Override
    public PreparedStatement build(Connection connection) {
        Collection<Column> columns = table.getColumns();

        String values =
                columns.stream().map(c -> c.getName() + " = ?").collect(Collectors.joining(", "));

        String where = null;

        PrimaryKey pk = table.getPrimaryKey();
        if (pk != null) {
            where = pk.getColumns().stream().map(c -> c + " = ?").collect(Collectors.joining(", "));
        }

        if (where == null || where.trim().isEmpty()) {
            where = "1=0";
        }

        String query = SQL_UPDATE;
        query = String.format(query, table.getName(), values, where);

        try {
            return connection.prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
