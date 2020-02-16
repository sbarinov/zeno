package domain.zeno.core.meta.data.impl.persistence;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.meta.data.IMetaDataManager;
import domain.zeno.core.meta.data.model.MetaFilter;
import domain.zeno.core.meta.data.model.MetaRecord;

public class PersistentMetaDataManager implements IMetaDataManager {
    @Override
    public MetaRecord create(MetaRecord record) {
        return null;
    }

    @Override
    public MetaRecord get(Object key) {
        return null;
    }

    @Override
    public Iterable<MetaRecord> list(Long offset, Integer limit, MetaFilter filter) {
        return null;
    }

    @Override
    public void delete(Object key) {

    }
}
