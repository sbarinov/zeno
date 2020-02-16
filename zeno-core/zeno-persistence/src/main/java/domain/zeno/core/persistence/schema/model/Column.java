package domain.zeno.core.persistence.schema.model;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import java.util.Objects;

public class Column {
    private String name;
    private ColumnType type;
    private ColumnConstraint constraint;
    private Object defaultValue;

    private Column() {
    }

    private Column(Builder builder) {
        name = builder.name;
        type = builder.type;
        constraint = builder.constraint;
        defaultValue = builder.defaultValue;
    }

    public String getName() {
        return name;
    }

    public ColumnType getType() {
        return type;
    }

    public ColumnConstraint getConstraint() {
        return constraint;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    @Override
    public String toString() {
        return "Column{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", constraint=" + constraint +
                ", defaultValue=" + defaultValue +
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
        Column column = (Column) o;
        return Objects.equals(name, column.name) &&
                Objects.equals(type, column.type) &&
                Objects.equals(constraint, column.constraint) &&
                Objects.equals(defaultValue, column.defaultValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, constraint, defaultValue);
    }

    public static final class Builder {
        private String name;
        private ColumnType type;
        private ColumnConstraint constraint;
        private Object defaultValue;

        public Builder() {
        }

        public Builder(Column copy) {
            this.name = copy.getName();
            this.type = copy.getType();
            this.constraint = copy.getConstraint();
            this.defaultValue = copy.getDefaultValue();
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder type(ColumnType type) {
            this.type = type;
            return this;
        }

        public Builder constraint(ColumnConstraint constraint) {
            this.constraint = constraint;
            return this;
        }

        public Builder defaultValue(Object defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }

        public Column build() {
            return new Column(this);
        }
    }
}
