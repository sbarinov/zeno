package domain.zeno.core.persistence.db.connection.jdbc;

/*
 * COPYRIGHT_PLACEHOLDER
 */

public interface IConnectionStringBuilder {
    String build(JdbcConnectionProfile profile);
}
