package domain.zeno.core.persistence.schema.jdbc;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.persistence.generic.SequentialProcessor;
import domain.zeno.core.persistence.schema.IGenericObjectActionFactory;
import domain.zeno.core.persistence.schema.model.Column;
import domain.zeno.core.persistence.schema.model.PrimaryKey;
import domain.zeno.core.persistence.schema.model.Table;
import domain.zeno.core.persistence.schema.jdbc.action.column.JdbcAddColumnStatement;
import domain.zeno.core.persistence.schema.jdbc.action.table.JdbcAddPrimaryKeyStatement;
import domain.zeno.core.persistence.schema.jdbc.action.table.JdbcCreateTableStatement;
import domain.zeno.core.pattern.common.IProcessor;
import domain.zeno.core.persistence.generic.jdbc.JdbcUpdateStatementExecutor;

import java.sql.Connection;

public class JdbcTableActionFactory implements IGenericObjectActionFactory<Connection, Table> {
    @Override
    public IProcessor<Connection, Void> create(Table table) {
        SequentialProcessor<Connection, Void> script = new SequentialProcessor<>();

        script.add(new JdbcUpdateStatementExecutor(new JdbcCreateTableStatement(table)));

        String sName = table.getName();
        for (Column column : table.getColumns()) {
            script.add(new JdbcUpdateStatementExecutor(new JdbcAddColumnStatement(sName, column)));
        }

        PrimaryKey pk = table.getPrimaryKey();
        if (pk != null) {
            script.add(new JdbcUpdateStatementExecutor(new JdbcAddPrimaryKeyStatement(sName, pk)));
        }

        return script;
    }

    @Override
    public IProcessor<Connection, Void> update(Table table) {
        // todo
        return null;
    }

    @Override
    public IProcessor<Connection, Void> delete(String name) {
        // todo
        return null;
    }
}
