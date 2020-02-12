package domain.zeno.core.cdm.v0;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import java.io.Serializable;
import java.util.Objects;

public class ConnectionSettings implements Serializable {
    private static final long serialVersionUID = 2030119413192629579L;

    private Protocol protocol;
    private String host;
    private Integer port;

    private ConnectionSettings() {
    }

    private ConnectionSettings(Builder builder) {
        protocol = builder.protocol;
        host = builder.host;
        port = builder.port;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public String getHost() {
        return host;
    }

    public Integer getPort() {
        return port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ConnectionSettings that = (ConnectionSettings) o;
        return protocol == that.protocol &&
                Objects.equals(host, that.host) &&
                Objects.equals(port, that.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(protocol, host, port);
    }

    @Override
    public String toString() {
        return "ConnectionSettings{" +
                "protocol=" + protocol +
                ", host='" + host + '\'' +
                ", port=" + port +
                '}';
    }

    public static final class Builder {
        private Protocol protocol;
        private String host;
        private Integer port;

        public Builder() {
        }

        public Builder(ConnectionSettings copy) {
            this.protocol = copy.getProtocol();
            this.host = copy.getHost();
            this.port = copy.getPort();
        }

        public Builder protocol(Protocol protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder host(String host) {
            this.host = host;
            return this;
        }

        public Builder port(Integer port) {
            this.port = port;
            return this;
        }

        public ConnectionSettings build() {
            return new ConnectionSettings(this);
        }
    }
}
