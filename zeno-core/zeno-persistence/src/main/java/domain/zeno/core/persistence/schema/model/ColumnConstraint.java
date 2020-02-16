package domain.zeno.core.persistence.schema.model;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import java.util.Objects;

public class ColumnConstraint {
    private Boolean nullable;

    private ColumnConstraint() {
    }

    private ColumnConstraint(Builder builder) {
        nullable = builder.nullable;
    }

    public Boolean getNullable() {
        return nullable;
    }

    @Override
    public String toString() {
        return "ColumnConstraint{" +
                "nullable=" + nullable +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ColumnConstraint that = (ColumnConstraint) o;
        return Objects.equals(nullable, that.nullable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nullable);
    }

    public static final class Builder {
        private Boolean nullable;

        public Builder() {
        }

        public Builder(ColumnConstraint copy) {
            this.nullable = copy.getNullable();
        }

        public Builder nullable(Boolean nullable) {
            this.nullable = nullable;
            return this;
        }

        public ColumnConstraint build() {
            return new ColumnConstraint(this);
        }
    }
}
