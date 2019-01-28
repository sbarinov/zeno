package org.zeno.core.persistence.db;

import java.sql.Connection;

public interface IConnectionFactory<T> {
    Connection getConnection(T connectionProfile);
}
