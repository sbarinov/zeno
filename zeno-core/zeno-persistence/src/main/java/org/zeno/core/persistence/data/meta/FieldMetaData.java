package org.zeno.core.persistence.data.meta;

import java.util.Objects;

public class FieldMetaData {
    private String name;
    private String description;
    private FieldType type;
    private boolean nullable;

    private FieldMetaData(Builder builder) {
        name = builder.name;
        description = builder.description;
        type = builder.type;
        nullable = builder.nullable;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public FieldType getType() {
        return type;
    }

    public boolean isNullable() {
        return nullable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FieldMetaData that = (FieldMetaData) o;
        return nullable == that.nullable &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, type, nullable);
    }

    public static final class Builder {
        private String name;
        private String description;
        private FieldType type;
        private boolean nullable;

        public Builder() {
        }

        public Builder(FieldMetaData copy) {
            this.name = copy.getName();
            this.description = copy.getDescription();
            this.type = copy.getType();
            this.nullable = copy.isNullable();
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder type(FieldType type) {
            this.type = type;
            return this;
        }

        public Builder nullable(boolean nullable) {
            this.nullable = nullable;
            return this;
        }

        public FieldMetaData build() {
            return new FieldMetaData(this);
        }
    }
}
