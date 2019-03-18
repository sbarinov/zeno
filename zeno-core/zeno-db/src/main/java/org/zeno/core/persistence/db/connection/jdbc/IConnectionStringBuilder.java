package org.zeno.core.persistence.db.connection.jdbc;

public interface IConnectionStringBuilder {
    String build(JdbcConnectionProfile profile);
}
