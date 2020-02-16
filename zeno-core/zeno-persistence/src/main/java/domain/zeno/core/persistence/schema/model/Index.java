package domain.zeno.core.persistence.schema.model;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class Index {
    private String name;
    private IndexType type;
    private Collection<String> columns = new ArrayList<>();

    private Index() {
    }

    private Index(Builder builder) {
        name = builder.name;
        type = builder.type;
        columns.addAll(builder.columns);
    }

    public String getName() {
        return name;
    }

    public IndexType getType() {
        return type;
    }

    public Collection<String> getColumns() {
        return columns != null ? new ArrayList<>(columns) : Collections.emptyList();
}

    @Override
    public String toString() {
        return "Index{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", columns=" + columns +
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
        Index index = (Index) o;
        return Objects.equals(name, index.name) &&
                type == index.type &&
                Objects.equals(columns, index.columns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, columns);
    }

    public static final class Builder {
        private String name;
        private IndexType type;
        private Collection<String> columns = new ArrayList<>();

        public Builder() {
        }

        public Builder(Index copy) {
            this.name = copy.getName();
            this.type = copy.getType();
            this.columns.addAll(copy.getColumns());
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder type(IndexType type) {
            this.type = type;
            return this;
        }

        public Builder column(String column) {
            if (column != null) {
                this.columns.add(column);
            }
            return this;
        }

        public Builder columns(Collection<String> columns) {
            this.columns.clear();
            if (columns != null) {
                this.columns.addAll(columns);
            }
            return this;
        }

        public Index build() {
            return new Index(this);
        }
    }
}
