package domain.zeno.core.persistence.connection.jdbc;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.cdm.v0.ConnectionSettings;

import java.util.Objects;

public class DefaultConnectionStringBuilder implements IConnectionStringBuilder {
    private static final String DEFAULT_FORMAT = "jdbc:%s:thin:@%s:%d:%s";

    private final String format;

    public DefaultConnectionStringBuilder(String format) {
        this.format = format;
    }

    public DefaultConnectionStringBuilder() {
        this(DEFAULT_FORMAT);
    }

    @Override
    public String build(JdbcConnectionProfile profile) {
        ConnectionSettings settings = profile.getConnectionSettings();
        JdbcDriver driver = profile.getDriver();

        return String.format(format, driver.getJdbcPrefix(), settings.getHost(),
                settings.getPort(), profile.getDatabaseName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DefaultConnectionStringBuilder that = (DefaultConnectionStringBuilder) o;
        return Objects.equals(format, that.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(format);
    }

    @Override
    public String toString() {
        return "CDefaultConnectionStringBuilder{" +
                "format='" + format + '\'' +
                '}';
    }
}
