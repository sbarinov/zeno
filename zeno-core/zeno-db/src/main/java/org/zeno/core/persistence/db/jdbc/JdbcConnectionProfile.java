package org.zeno.core.persistence.db.jdbc;

import org.zeno.core.cdm.v0.ConnectionSettings;
import org.zeno.core.cdm.v0.NamePasswordCredential;

import java.util.Objects;

public class JdbcConnectionProfile {
    private JdbcDriver driver;
    private ConnectionSettings connectionSettings;
    private NamePasswordCredential credential;
    private String databaseName;

    public JdbcConnectionProfile() {
    }

    private JdbcConnectionProfile(Builder builder) {
        driver = builder.driver;
        connectionSettings = builder.connectionSettings;
        credential = builder.credential;
        databaseName = builder.databaseName;
    }

    public JdbcDriver getDriver() {
        return driver;
    }

    public ConnectionSettings getConnectionSettings() {
        return connectionSettings;
    }

    public NamePasswordCredential getCredential() {
        return credential;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        JdbcConnectionProfile that = (JdbcConnectionProfile) o;
        return driver == that.driver &&
                Objects.equals(connectionSettings, that.connectionSettings) &&
                Objects.equals(credential, that.credential) &&
                Objects.equals(databaseName, that.databaseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driver, connectionSettings, credential, databaseName);
    }

    @Override
    public String toString() {
        return "JdbcConnectionProfile{" +
                "driver=" + driver +
                ", connectionSettings=" + connectionSettings +
                ", credential=" + credential +
                ", databaseName='" + databaseName + '\'' +
                '}';
    }

    public static final class Builder {
        private JdbcDriver driver;
        private ConnectionSettings connectionSettings;
        private NamePasswordCredential credential;
        private String databaseName;

        public Builder() {
        }

        public Builder(JdbcConnectionProfile copy) {
            this.driver = copy.getDriver();
            this.connectionSettings = copy.getConnectionSettings();
            this.credential = copy.getCredential();
            this.databaseName = copy.getDatabaseName();
        }

        public Builder driver(JdbcDriver driver) {
            this.driver = driver;
            return this;
        }

        public Builder connectionSettings(ConnectionSettings connectionSettings) {
            this.connectionSettings = connectionSettings;
            return this;
        }

        public Builder credential(NamePasswordCredential credential) {
            this.credential = credential;
            return this;
        }

        public Builder databaseName(String databaseName) {
            this.databaseName = databaseName;
            return this;
        }

        public JdbcConnectionProfile build() {
            return new JdbcConnectionProfile(this);
        }
    }
}
