package domain.zeno.core.persistence.db.schema.jdbc;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.persistence.db.schema.generic.model.Sequence;
import domain.zeno.core.persistence.db.schema.generic.IGenericObjectActionFactory;
import domain.zeno.core.pattern.common.IProcessor;

import java.sql.Connection;

public class JdbcSequenceActionFactory
        implements IGenericObjectActionFactory<Connection, Sequence> {
    @Override
    public IProcessor<Connection, Void> create(Sequence sequence) {
        return null;
    }

    @Override
    public IProcessor<Connection, Void> update(Sequence sequence) {
        return null;
    }

    @Override
    public IProcessor<Connection, Void> delete(String name) {
        return null;
    }
}
