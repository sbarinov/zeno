package domain.zeno.core.persistence.data;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.pattern.common.IProcessor;
import domain.zeno.core.persistence.data.model.FetchQuery;

public interface IGenericRecordActionFactory<CONTEXT, T extends IRecord<K>, K> {
    IProcessor<CONTEXT, Iterable<K>> create(Iterable<T> records);

    IProcessor<CONTEXT, Iterable<K>> update(Iterable<T> records);

    IProcessor<CONTEXT, Iterable<K>> fetch(FetchQuery query);

    IProcessor<CONTEXT, Iterable<T>> fetch(Iterable<K> keys);

    IProcessor<CONTEXT, Iterable<K>> delete(Iterable<K> records);
}
