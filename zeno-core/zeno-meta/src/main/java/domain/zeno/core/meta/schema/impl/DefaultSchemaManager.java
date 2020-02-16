package domain.zeno.core.meta.schema.impl;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.meta.data.IMetaDataManagerFactory;
import domain.zeno.core.meta.schema.IMetaSchemaManager;
import domain.zeno.core.meta.schema.model.MetaObject;
import domain.zeno.core.meta.schema.model.MetaObjectType;

import java.util.Collection;

public class DefaultSchemaManager implements IMetaSchemaManager {
    private final IMetaDataManagerFactory factory;
    private final MetaStorageProfile profile;

    public DefaultSchemaManager(IMetaDataManagerFactory factory, MetaStorageProfile profile) {
        this.factory = factory;
        this.profile = profile;
    }

    @Override
    public MetaObject create(MetaObject object) {
        return null;
    }

    @Override
    public MetaObject get(String name) {
        return null;
    }

    @Override
    public Iterable<MetaObject> list(Long offset, Integer limit, String nameFilter,
            Collection<MetaObjectType> typeFilters) {
        return null;
    }

    @Override
    public MetaObject update(MetaObject object) {
        return null;
    }

    @Override
    public void delete(String name) {

    }
}
