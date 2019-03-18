package org.zeno.core.persistence.db.data.provider.jdbc;

import org.zeno.core.bean.IBeanFactory;
import org.zeno.core.pattern.eip.ITranslator;
import org.zeno.core.persistence.data.meta.IObjectMetaDataFactory;
import org.zeno.core.persistence.data.meta.ObjectMetaData;
import org.zeno.core.persistence.data.model.FieldSet;
import org.zeno.core.persistence.data.model.IDataObject;
import org.zeno.core.persistence.data.provider.IDataObjectProvider;
import org.zeno.core.persistence.data.provider.IFetchInfuser;
import org.zeno.core.persistence.db.data.provider.jdbc.statement.IStatementBuilder;
import org.zeno.core.persistence.db.data.provider.jdbc.statement.SelectStatementBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.function.Supplier;

public class JdbcDataObjectProvider<T extends IDataObject<K>, K>
        implements IDataObjectProvider<T, K> {
    private final Supplier<Connection> connectionFactory;
    private final IBeanFactory<T> beanFactory;

    public JdbcDataObjectProvider(Supplier<Connection> connectionFactory,
            IBeanFactory<T> beanFactory) {
        this.connectionFactory = connectionFactory;
        this.beanFactory = beanFactory;
    }

    @Override
    public T get(K key) {
        Connection connection = connectionFactory.get();

        IObjectMetaDataFactory metaDataFactory = null;
        String objectName = null;
        ObjectMetaData metaData = metaDataFactory.getMetaData(objectName);

        IStatementBuilder statementBuilder = new SelectStatementBuilder(metaData, connection);

        FieldSet fieldKey = new FieldSet();
        PreparedStatement statement = statementBuilder.prepare(objectName, fieldKey);

        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ITranslator<ResultSet, Collection<T>> translator =
                new ResultSetObjectFactory<>(beanFactory, metaData);

        Collection<T> records = translator.translate(resultSet);

        if (records.isEmpty()) {
            throw new RuntimeException("Resource not found");
        } else if (records.size() > 1) {
            throw new RuntimeException("Inconsistent object access model");
        }

        return records.iterator().next();
    }

    @Override
    public Collection<T> list(Long offset, Integer limit) {
        return null;
    }

    @Override
    public Collection<T> fetch(Long offset, Integer limit, IFetchInfuser infuser) {
        return null;
    }

    @Override
    public T create(T object) {
        return null;
    }

    @Override
    public T update(T object) {
        return null;
    }

    @Override
    public void delete(K key) {

    }
}
