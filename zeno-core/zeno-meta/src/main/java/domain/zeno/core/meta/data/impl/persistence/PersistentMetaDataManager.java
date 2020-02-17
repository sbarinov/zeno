package domain.zeno.core.meta.data.impl.persistence;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.bean.supplier.ValueContainer;
import domain.zeno.core.meta.data.IMetaDataManager;
import domain.zeno.core.meta.data.model.MetaFilter;
import domain.zeno.core.meta.data.model.MetaRecord;
import domain.zeno.core.meta.schema.model.MetaObject;
import domain.zeno.core.pattern.common.IProcessor;
import domain.zeno.core.persistence.data.IGenericRecordActionFactory;
import domain.zeno.core.persistence.data.model.FetchQuery;
import domain.zeno.core.persistence.data.model.GenericKey;
import domain.zeno.core.persistence.data.model.GenericRecord;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public class PersistentMetaDataManager<T> implements IMetaDataManager {
    private final MetaObject metaObject;
    private final IGenericRecordActionFactory<T, GenericRecord, GenericKey> persistentActionFactory;
    private final IPersistentActionExecutor<T> actionExecutor;

    public PersistentMetaDataManager(MetaObject metaObject,
            IGenericRecordActionFactory<T, GenericRecord, GenericKey> persistentActionFactory,
            IPersistentActionExecutor<T> actionExecutor) {
        this.metaObject = metaObject;
        this.persistentActionFactory = persistentActionFactory;
        this.actionExecutor = actionExecutor;
    }

    @Override
    public MetaRecord create(MetaRecord record) {
        GenericRecord.Builder target = new GenericRecord.Builder();

        // todo MetaRecord to GenericRecord

        IProcessor<T, Iterable<GenericKey>> action =
                persistentActionFactory.create(Collections.singletonList(target.build()));

        Iterable<GenericKey> resultKeys = actionExecutor.execute(action);

        Iterator<GenericKey> keys = resultKeys.iterator();
        if (keys.hasNext()) {
            GenericKey key = keys.next();
            // todo MetaRecord and GenericKey to MetaRecord
        }

        return record;
    }

    @Override
    public MetaRecord get(Map<String, ValueContainer> key) {
        GenericKey target = new GenericKey();

        // todo Map to GenericKey using MetaObject

        IProcessor<T, Iterable<GenericRecord>> action =
                persistentActionFactory.fetch(Collections.singletonList(target));

        Iterable<GenericRecord> resultRecords = actionExecutor.execute(action);

        Iterator<GenericRecord> records = resultRecords.iterator();

        MetaRecord targetRecord = null;
        if (records.hasNext()) {
            GenericRecord record = records.next();
            // todo GenericRecord to MetaRecord
        }

        return targetRecord;
    }

    @Override
    public Iterable<MetaRecord> list(Long offset, Integer limit, MetaFilter filter) {

        FetchQuery query = new FetchQuery();

        // todo MetaFilter to FetchQuery using MetaObject

        IProcessor<T, Iterable<GenericKey>> action =
                persistentActionFactory.fetch(query);

        Iterable<GenericKey> resultKeys = actionExecutor.execute(action);

        // todo implement Iterable to wrap GenericKey to GenericRecord fetch
        // todo implement Iterable to wrap GenericRecord to MetaRecord mapping
        // todo implement sequential Iterable to wrap previous two Iterable implementations

        return null;
    }

    @Override
    public MetaRecord update(MetaRecord record) {
        GenericRecord.Builder target = new GenericRecord.Builder();

        // todo MetaRecord to GenericRecord

        IProcessor<T, Iterable<GenericKey>> action =
                persistentActionFactory.update(Collections.singletonList(target.build()));

        actionExecutor.execute(action);

        return record;
    }

    @Override
    public void delete(Map<String, ValueContainer> key) {
        GenericKey target = new GenericKey();

        // todo Map to GenericKey using MetaObject

        IProcessor<T, Iterable<GenericKey>> action =
                persistentActionFactory.delete(Collections.singletonList(target));

        actionExecutor.execute(action);
    }
}
