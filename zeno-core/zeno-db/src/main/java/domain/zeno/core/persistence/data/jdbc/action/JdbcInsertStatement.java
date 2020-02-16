package domain.zeno.core.persistence.data.jdbc.action;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.persistence.generic.jdbc.IJdbcStatementBuilder;
import domain.zeno.core.persistence.schema.model.Column;
import domain.zeno.core.persistence.schema.model.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class JdbcInsertStatement implements IJdbcStatementBuilder {
    private static final String SQL_INSERT = "INSERT INTO %s (%s) VALUES (%s)";

    private final Table table;

    public JdbcInsertStatement(Table table) {
        this.table = table;
    }

    @Override
    public PreparedStatement build(Connection connection) {
        Collection<Column> columns = table.getColumns();

        String columnNames =
                columns.stream().map(Column::getName).collect(Collectors.joining(", "));
        String columnValues = String.join(", ", Collections.nCopies(columns.size(), "?"));

        String query = SQL_INSERT;
        query = String.format(query, table.getName(), columnNames, columnValues);

        try {
            return connection.prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
