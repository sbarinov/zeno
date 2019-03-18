package org.zeno.core.persistence.db.connection;

import java.sql.Connection;

public interface IConnectionFactory<T> {
    Connection getConnection(T connectionProfile);
}
