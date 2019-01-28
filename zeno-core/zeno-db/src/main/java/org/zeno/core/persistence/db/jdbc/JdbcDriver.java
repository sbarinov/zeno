package org.zeno.core.persistence.db.jdbc;

public enum JdbcDriver {
    ORACLE("oracle", "oracle.jdbc.driver.OracleDriver");

    private final String jdbcPrefix;
    private final String className;
    private boolean initialized = false;

    JdbcDriver(String jdbcPrefix, String className) {
        this.jdbcPrefix = jdbcPrefix;
        this.className = className;
    }

    public String getJdbcPrefix() {
        return jdbcPrefix;
    }

    public String getClassName() {
        return className;
    }

    public synchronized void init() {
        if (!initialized) {
            try {
                Class.forName(getClassName());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            initialized = true;
        }
    }
}
