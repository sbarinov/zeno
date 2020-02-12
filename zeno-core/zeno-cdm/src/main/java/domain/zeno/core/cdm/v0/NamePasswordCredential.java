package domain.zeno.core.cdm.v0;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import java.io.Serializable;
import java.util.Objects;

public class NamePasswordCredential implements Serializable {
    private static final long serialVersionUID = 4664157345892042731L;

    private String name;
    private String password;

    private NamePasswordCredential(Builder builder) {
        name = builder.name;
        password = builder.password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NamePasswordCredential that = (NamePasswordCredential) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }

    @Override
    public String toString() {
        return "NamePasswordCredential{" +
                "name='" + name + '\'' +
                ", password='[SECURE-DATA]'";
    }

    public static final class Builder {
        private String name;
        private String password;

        public Builder() {
        }

        public Builder(NamePasswordCredential copy) {
            this.name = copy.getName();
            this.password = copy.getPassword();
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public NamePasswordCredential build() {
            return new NamePasswordCredential(this);
        }
    }
}
