package domain.zeno.core.persistence.db.schema.generic.model;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class Table {
    private String name;
    private Collection<Column> columns = new ArrayList<>();
    private Collection<Index> indexes = new ArrayList<>();
    private PrimaryKey primaryKey;
    private String tablespace;

    private Table(Builder builder) {
        name = builder.name;
        columns.addAll(builder.columns);
        indexes.addAll(builder.indexes);
        primaryKey = builder.primaryKey;
        tablespace = builder.tablespace;
    }

    public String getName() {
        return name;
    }

    public Collection<Column> getColumns() {
        return columns != null ? new ArrayList<>(columns) : Collections.emptyList();
    }

    public Collection<Index> getIndexes() {
        return indexes != null ? new ArrayList<>(indexes) : Collections.emptyList();
    }

    public PrimaryKey getPrimaryKey() {
        return primaryKey;
    }

    public String getTablespace() {
        return tablespace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Table table = (Table) o;
        return Objects.equals(name, table.name) && Objects.equals(columns, table.columns) &&
                Objects.equals(indexes, table.indexes) &&
                Objects.equals(primaryKey, table.primaryKey) &&
                Objects.equals(tablespace, table.tablespace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, columns, indexes, primaryKey, tablespace);
    }

    @Override
    public String toString() {
        return "Table{" + "name='" + name + '\'' + ", columns=" + columns + ", indexes=" + indexes +
                ", primaryKey=" + primaryKey + ", tablespace='" + tablespace + '\'' + '}';
    }

    public static final class Builder {
        private String name;
        private Collection<Column> columns = new ArrayList<>();
        private Collection<Index> indexes = new ArrayList<>();
        private PrimaryKey primaryKey;
        private String tablespace;

        public Builder() {
        }

        public Builder(Table copy) {
            this.name = copy.getName();
            this.columns.addAll(copy.getColumns());
            this.indexes.addAll(copy.getIndexes());
            this.primaryKey = copy.getPrimaryKey();
            this.tablespace = copy.getTablespace();
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder column(Column column) {
            if (column != null) {
                this.columns.add(column);
            }
            return this;
        }

        public Builder columns(Collection<Column> columns) {
            this.columns.clear();
            if (columns != null) {
                this.columns.addAll(columns);
            }
            return this;
        }

        public Builder index(Index index) {
            if (index != null) {
                this.indexes.add(index);
            }
            return this;
        }

        public Builder indexes(Collection<Index> indexes) {
            this.indexes.clear();
            if (indexes != null) {
                this.indexes.addAll(indexes);
            }
            return this;
        }

        public Builder primaryKey(PrimaryKey primaryKey) {
            this.primaryKey = primaryKey;
            return this;
        }

        public Builder tablespace(String tablespace) {
            this.tablespace = tablespace;
            return this;
        }

        public Table build() {
            return new Table(this);
        }
    }
}
