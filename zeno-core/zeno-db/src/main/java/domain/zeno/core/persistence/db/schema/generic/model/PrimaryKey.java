package domain.zeno.core.persistence.db.schema.generic.model;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import java.util.*;

public class PrimaryKey {
    private String name;
    private Collection<String> columns = new ArrayList<>();

    private PrimaryKey() {
    }

    private PrimaryKey(Builder builder) {
        name = builder.name;
        columns.addAll(builder.columns);
    }

    public String getName() {
        return name;
    }

    public Collection<String> getColumns() {
        return columns != null ? new ArrayList<>(columns) : Collections.emptyList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PrimaryKey that = (PrimaryKey) o;
        return Objects.equals(name, that.name) && Objects.equals(columns, that.columns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, columns);
    }

    @Override
    public String toString() {
        return "PrimaryKey{" + "name='" + name + '\'' + ", columns=" + columns + '}';
    }

    public static final class Builder {
        private String name;
        private Collection<String> columns = new ArrayList<>();

        public Builder() {
        }

        public Builder(PrimaryKey copy) {
            this.name = copy.getName();
            this.columns.addAll(copy.getColumns());
        }

        public Builder name(String name) {
            this.name = name;
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

        public PrimaryKey build() {
            List<String> errors = new ArrayList<>();

            if (name == null || name.trim().isEmpty()) {
                errors.add("Name cannot be empty");
            }

            if (columns.isEmpty()) {
                errors.add("Columns are missing");
            }

            if (!errors.isEmpty()) {
                throw new RuntimeException(
                        "Primary Key build error(s): " + String.join("; ", errors));
            }

            return new PrimaryKey(this);
        }
    }
}
