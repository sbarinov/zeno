package org.zeno.core.persistence.data.provider;

import org.zeno.core.persistence.data.model.IDataObject;

import java.util.Collection;

public interface IDataObjectProvider<T extends IDataObject<K>, K> {
    T get(K key);

    Collection<T> list(Long offset, Integer limit);

    Collection<T> fetch(Long offset, Integer limit, IFetchInfuser infuser);

    T create(T object);

    T update(T object);

    void delete(K key);
}
