package domain.zeno.core.meta.schema;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.meta.schema.model.MetaObject;
import domain.zeno.core.meta.schema.model.MetaObjectType;

import java.util.Collection;

public interface IMetaSchemaManager {
    MetaObject create(MetaObject object);

    MetaObject get(String name);

    Iterable<MetaObject> list(Long offset, Integer limit, String nameFilter,
            Collection<MetaObjectType> typeFilters);

    MetaObject update(MetaObject object);

    void delete(String name);
}
