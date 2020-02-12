package domain.zeno.core.persistence.db.data.jdbc;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.persistence.db.data.generic.IGenericRecordActionFactory;
import domain.zeno.core.persistence.db.data.generic.model.FetchQuery;
import domain.zeno.core.persistence.db.data.generic.model.GenericKey;
import domain.zeno.core.persistence.db.data.generic.model.GenericRecord;
import domain.zeno.core.persistence.db.generic.jdbc.IJdbcStatementExecutor;
import domain.zeno.core.persistence.db.schema.generic.model.Table;

public class JdbcTableRecordActionFactory
        implements IGenericRecordActionFactory<GenericRecord, GenericKey> {
    private final Table table;

    public JdbcTableRecordActionFactory(Table table) {
        this.table = table;
    }

    @Override
    public IJdbcStatementExecutor<Iterable<GenericKey>> create(Iterable<GenericRecord> records) {
        return null;
    }

    @Override
    public IJdbcStatementExecutor<Iterable<GenericKey>> update(Iterable<GenericRecord> records) {
        return null;
    }

    @Override
    public IJdbcStatementExecutor<Iterable<GenericKey>> fetch(FetchQuery query) {
        return null;
    }

    @Override
    public IJdbcStatementExecutor<Iterable<GenericRecord>> fetch(Iterable<GenericKey> keys) {
        return null;
    }

    @Override
    public IJdbcStatementExecutor<Iterable<GenericKey>> delete(Iterable<GenericKey> records) {
        return null;
    }
}
