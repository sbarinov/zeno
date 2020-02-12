package domain.zeno.core.persistence.db.generic.jdbc;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.pattern.common.IProcessor;

import java.sql.Connection;
import java.sql.PreparedStatement;

public interface IJdbcStatementBuilder extends IProcessor<Connection, PreparedStatement> {
    @Override
    default PreparedStatement process(Connection connection) {
        return build(connection);
    }

    PreparedStatement build(Connection connection);
}
