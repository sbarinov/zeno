package org.zeno.core.persistence.db.connection.jdbc;

import org.zeno.core.cdm.v0.NamePasswordCredential;
import org.zeno.core.persistence.db.connection.IConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionFactory implements IConnectionFactory<JdbcConnectionProfile> {
    private final IConnectionStringBuilder csBuilder;

    public JdbcConnectionFactory(IConnectionStringBuilder csBuilder) {
        this.csBuilder = csBuilder;
    }

    public JdbcConnectionFactory() {
        this(new CDefaultConnectionStringBuilder());
    }

    @Override
    public Connection getConnection(JdbcConnectionProfile profile) {
        profile.getDriver().init();

        String connectionString = csBuilder.build(profile);

        NamePasswordCredential credential = profile.getCredential();

        Connection connection;

        try {
            if (credential != null) {
                connection = DriverManager.getConnection(connectionString, credential.getName(),
                        credential.getPassword());
            } else {
                connection = DriverManager.getConnection(connectionString);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }
}
