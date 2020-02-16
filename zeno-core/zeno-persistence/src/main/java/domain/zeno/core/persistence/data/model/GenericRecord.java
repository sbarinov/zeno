package domain.zeno.core.persistence.data.model;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.persistence.data.IRecord;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GenericRecord implements IRecord<GenericKey> {
    private GenericKey key;
    private Map<String, ValueContainer> values = new HashMap<>();

    private GenericRecord() {
    }

    private GenericRecord(Builder builder) {
        key = builder.key;
        values = builder.values;
    }

    @Override
    public GenericKey getKey() {
        return key;
    }

    public Map<String, ValueContainer> getValues() {
        return values != null ? new HashMap<>(values) : Collections.emptyMap();
    }

    @Override
    public String toString() {
        return "GenericRecord{" +
                "key=" + key +
                ", values=" + values +
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
        GenericRecord that = (GenericRecord) o;
        return Objects.equals(key, that.key) &&
                Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, values);
    }

    public static final class Builder {
        private GenericKey key;
        private Map<String, ValueContainer> values = new HashMap<>();

        public Builder() {
        }

        public Builder(GenericRecord copy) {
            this.key = copy.getKey();
            this.values.putAll(copy.getValues());
        }

        public Builder key(GenericKey key) {
            this.key = key;
            return this;
        }

        public Builder value(String key, ValueContainer value) {
            if (key != null && !key.trim().isEmpty()) {
                this.values.put(key, value);
            }
            return this;
        }

        public Builder values(Map<String, ValueContainer> values) {
            this.values.clear();
            if (values != null) {
                this.values.putAll(values);
            }
            return this;
        }

        public GenericRecord build() {
            return new GenericRecord(this);
        }
    }
}
