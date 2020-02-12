package domain.zeno.core.persistence.db.data.jdbc.action;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.persistence.db.generic.jdbc.IJdbcStatementBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcBatchStatement implements IJdbcStatementBuilder {
    private final IJdbcStatementBuilder delegate;
    private PreparedStatement preparedStatement;

    public JdbcBatchStatement(IJdbcStatementBuilder delegate) {
        this.delegate = delegate;
    }

    @Override
    public PreparedStatement build(Connection connection) {
        if (preparedStatement == null) {
            preparedStatement = delegate.build(connection);
        } else {
            try {
                preparedStatement.addBatch();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return preparedStatement;
    }
}
