package org.zeno.core.persistence.data.meta;

import java.util.ArrayList;
import java.util.Collection;

public class ObjectMetaData {
    private String metaClass;
    private PrimaryKeyMetaData primaryKeyMetaData;
    private final Collection<FieldMetaData> fieldMetaData = new ArrayList<>();

    private ObjectMetaData(Builder builder) {
        metaClass = builder.metaClass;
        primaryKeyMetaData = builder.primaryKeyMetaData;
        fieldMetaData.addAll(builder.fieldMetaData);
    }

    public String getMetaClass() {
        return metaClass;
    }

    public PrimaryKeyMetaData getPrimaryKeyMetaData() {
        return primaryKeyMetaData;
    }

    public Collection<FieldMetaData> getFieldMetaData() {
        return new ArrayList<>(fieldMetaData);
    }

    public static final class Builder {
        private String metaClass;
        private PrimaryKeyMetaData primaryKeyMetaData;
        private final Collection<FieldMetaData> fieldMetaData = new ArrayList<>();

        public Builder() {
        }

        public Builder(ObjectMetaData copy) {
            this.metaClass = copy.getMetaClass();
            this.primaryKeyMetaData = copy.getPrimaryKeyMetaData();
            this.fieldMetaData.addAll(copy.getFieldMetaData());
        }

        public Builder metaClass(String metaClass) {
            this.metaClass = metaClass;
            return this;
        }

        public Builder primaryKeyMetaData(PrimaryKeyMetaData primaryKeyMetaData) {
            this.primaryKeyMetaData = primaryKeyMetaData;
            return this;
        }

        public Builder fieldMetaData(FieldMetaData fieldMetaData) {
            this.fieldMetaData.add(fieldMetaData);
            return this;
        }

        public Builder fieldMetaData(Collection<FieldMetaData> fieldMetaData) {
            this.fieldMetaData.clear();
            this.fieldMetaData.addAll(fieldMetaData);
            return this;
        }

        public ObjectMetaData build() {
            return new ObjectMetaData(this);
        }
    }
}
