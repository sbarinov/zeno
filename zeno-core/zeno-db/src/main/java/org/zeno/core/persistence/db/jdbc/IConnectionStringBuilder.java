package org.zeno.core.persistence.db.jdbc;

public interface IConnectionStringBuilder {
    String build(JdbcConnectionProfile profile);
}
