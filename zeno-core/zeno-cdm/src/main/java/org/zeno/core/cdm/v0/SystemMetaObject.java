/*
 *
 * COPYRIGHT_PLACEHOLDER
 *
 */

package org.zeno.core.cdm.v0;

import java.util.Objects;

public class SystemMetaObject {
    private long id;
    private String name;
    private String description;

    private SystemMetaObject(Builder builder) {
        id = builder.id;
        name = builder.name;
        description = builder.description;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "SystemMetaObject{" + "id=" + id + ", name='" + name + '\'' + ", description='" +
                description + '\'' + super.toString() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SystemMetaObject that = (SystemMetaObject) o;
        return id == that.id && Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    public static final class Builder {
        private long id;
        private String name;
        private String description;

        public Builder() {
        }

        public Builder(SystemMetaObject copy) {
            this.id = copy.getId();
            this.name = copy.getName();
            this.description = copy.getDescription();
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public SystemMetaObject build() {
            return new SystemMetaObject(this);
        }
    }
}
