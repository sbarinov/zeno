package domain.zeno.core.persistence.db.connection;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import java.sql.Connection;

public interface IConnectionFactory<T> {
    Connection getConnection(T connectionProfile);
}
