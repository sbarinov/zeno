package org.zeno.core.persistence.db.data.provider.jdbc.statement;

import org.zeno.core.persistence.data.meta.FieldMetaData;
import org.zeno.core.persistence.data.meta.ObjectMetaData;
import org.zeno.core.persistence.data.model.FieldSet;
import org.zeno.core.persistence.data.model.IValueContainer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectStatementBuilder implements IStatementBuilder {
    private final ObjectMetaData metaData;
    private final Connection connection;

    public SelectStatementBuilder(ObjectMetaData metaData, Connection connection) {
        this.metaData = metaData;
        this.connection = connection;
    }

    @Override
    public PreparedStatement prepare(String objectName, FieldSet fieldSet) {
        String tableName = metaData.getMetaClass();

        StringBuilder query = new StringBuilder("SELECT t.* FROM " + tableName + " t\n");

        if (!fieldSet.isEmpty()) {
            query.append("WHERE\n");

            List<String> conditions = new ArrayList<>();
            for (FieldMetaData field : fieldSet.keySet()) {
                conditions.add(field.getName() + " = {?}");
            }

            query.append(String.join("\n", conditions));
        }

        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(query.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (!fieldSet.isEmpty()) {
            StatementSetter setter = new StatementSetter(statement);

            for (IValueContainer field : fieldSet.values()) {
                try {
                    setter.set(field);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return statement;
    }
}
