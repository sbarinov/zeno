package domain.zeno.core.persistence.data.jdbc;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.persistence.data.IGenericRecordActionFactory;
import domain.zeno.core.persistence.data.model.FetchQuery;
import domain.zeno.core.persistence.data.model.GenericKey;
import domain.zeno.core.persistence.data.model.GenericRecord;
import domain.zeno.core.persistence.generic.jdbc.IJdbcStatementExecutor;
import domain.zeno.core.persistence.schema.model.Table;

import java.sql.Connection;

public class JdbcTableRecordActionFactory
        implements IGenericRecordActionFactory<Connection, GenericRecord, GenericKey> {
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
