package domain.zeno.core.persistence.schema.model;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import java.util.Objects;

public class Sequence {
    private String name;
    private Long initialValue;

    private Sequence() {
    }

    private Sequence(Builder builder) {
        name = builder.name;
        initialValue = builder.initialValue;
    }

    public String getName() {
        return name;
    }

    public Long getInitialValue() {
        return initialValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Sequence sequence = (Sequence) o;
        return Objects.equals(name, sequence.name) &&
                Objects.equals(initialValue, sequence.initialValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, initialValue);
    }

    @Override
    public String toString() {
        return "Sequence{" + "name='" + name + '\'' + ", initialValue=" + initialValue + '}';
    }

    public static final class Builder {
        private String name;
        private Long initialValue;

        public Builder() {
        }

        public Builder(Sequence copy) {
            this.name = copy.getName();
            this.initialValue = copy.getInitialValue();
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder initialValue(Long initialValue) {
            this.initialValue = initialValue;
            return this;
        }

        public Sequence build() {
            return new Sequence(this);
        }
    }
}
