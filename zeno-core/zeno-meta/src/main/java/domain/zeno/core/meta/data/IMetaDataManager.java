package domain.zeno.core.meta.data;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.bean.supplier.ValueContainer;
import domain.zeno.core.meta.data.model.MetaFilter;
import domain.zeno.core.meta.data.model.MetaRecord;

import java.util.Map;

public interface IMetaDataManager {
    MetaRecord create(MetaRecord record);

    MetaRecord get(Map<String, ValueContainer> key);

    Iterable<MetaRecord> list(Long offset, Integer limit, MetaFilter filter);

    MetaRecord update(MetaRecord record);

    void delete(Map<String, ValueContainer> key);
}
