package domain.zeno.core.persistence.db.generic.jdbc;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.pattern.common.IProcessor;

import java.sql.Connection;

public interface IJdbcStatementExecutor<T> extends IProcessor<Connection, T> {
    @Override
    default T process(Connection connection) {
        execute(connection);
        return null;
    }

    T execute(Connection connection);
}
