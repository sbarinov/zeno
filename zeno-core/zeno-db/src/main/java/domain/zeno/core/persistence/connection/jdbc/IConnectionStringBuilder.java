package domain.zeno.core.persistence.connection.jdbc;

/*
 * COPYRIGHT_PLACEHOLDER
 */

public interface IConnectionStringBuilder {
    String build(JdbcConnectionProfile profile);
}
