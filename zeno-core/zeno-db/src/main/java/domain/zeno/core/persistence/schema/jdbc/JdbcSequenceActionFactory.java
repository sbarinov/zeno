package domain.zeno.core.persistence.schema.jdbc;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.pattern.common.IProcessor;
import domain.zeno.core.persistence.schema.IGenericObjectActionFactory;
import domain.zeno.core.persistence.schema.model.Sequence;

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
