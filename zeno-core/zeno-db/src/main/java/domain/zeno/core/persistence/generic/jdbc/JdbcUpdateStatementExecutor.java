package domain.zeno.core.persistence.generic.jdbc;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUpdateStatementExecutor implements IJdbcStatementExecutor<Void> {
    private final IJdbcStatementBuilder statementBuilder;

    public JdbcUpdateStatementExecutor(IJdbcStatementBuilder statementBuilder) {
        this.statementBuilder = statementBuilder;
    }

    @Override
    public Void execute(Connection connection) {
        try (PreparedStatement statement = statementBuilder.build(connection)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
