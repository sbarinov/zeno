package org.zeno.core.persistence.db.data.model;

import org.zeno.core.cdm.v0.SystemMetaObject;
import org.zeno.core.persistence.data.model.IDataObject;

public class SystemMetaObjectOrm implements IDataObject<Long> {
    private SystemMetaObject delegate;

    @Override
    public Long getKey() {
        return delegate.getId();
    }

    public SystemMetaObject getDelegate() {
        return delegate;
    }
}
