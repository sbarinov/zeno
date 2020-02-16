package domain.zeno.core.meta.data;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.meta.data.model.MetaFilter;
import domain.zeno.core.meta.data.model.MetaRecord;

public interface IMetaDataManager {
    MetaRecord create(MetaRecord record);

    MetaRecord get(Object key);

    Iterable<MetaRecord> list(Long offset, Integer limit, MetaFilter filter);

    void delete(Object key);
}
