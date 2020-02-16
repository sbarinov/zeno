package domain.zeno.core.persistence.connection;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import java.sql.Connection;

public interface IConnectionFactory<T> {
    Connection getConnection(T connectionProfile);
}
