package domain.zeno.core.persistence.db.data.generic;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.persistence.db.data.generic.model.FetchQuery;
import domain.zeno.core.persistence.db.generic.jdbc.IJdbcStatementExecutor;

public interface IGenericRecordActionFactory<T extends IRecord<K>, K> {
    IJdbcStatementExecutor<Iterable<K>> create(Iterable<T> records);

    IJdbcStatementExecutor<Iterable<K>> update(Iterable<T> records);

    IJdbcStatementExecutor<Iterable<K>> fetch(FetchQuery query);

    IJdbcStatementExecutor<Iterable<T>> fetch(Iterable<K> keys);

    IJdbcStatementExecutor<Iterable<K>> delete(Iterable<K> records);
}
