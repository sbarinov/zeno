package domain.zeno.core.persistence.schema.model;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import java.util.Objects;

public class ColumnType {
    private ColumnDataType type;
    private Integer size;

    private ColumnType() {
    }

    private ColumnType(Builder builder) {
        type = builder.type;
        size = builder.size;
    }

    public ColumnDataType getType() {
        return type;
    }

    public Integer getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "ColumnType{" +
                "type=" + type +
                ", size=" + size +
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
        ColumnType that = (ColumnType) o;
        return type == that.type &&
                Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, size);
    }

    public static final class Builder {
        private ColumnDataType type;
        private Integer size;

        public Builder() {
        }

        public Builder(ColumnType copy) {
            this.type = copy.getType();
            this.size = copy.getSize();
        }

        public Builder type(ColumnDataType type) {
            this.type = type;
            return this;
        }

        public Builder size(Integer size) {
            this.size = size;
            return this;
        }

        public ColumnType build() {
            return new ColumnType(this);
        }
    }
}
