package org.zeno.core.persistence.db.data.provider.jdbc;

import org.zeno.core.bean.IBeanFactory;
import org.zeno.core.pattern.eip.ITranslator;
import org.zeno.core.persistence.data.meta.FieldMetaData;
import org.zeno.core.persistence.data.meta.ObjectMetaData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ResultSetObjectFactory<T> implements ITranslator<ResultSet, Collection<T>> {
    private final IBeanFactory<T> beanFactory;
    private final ObjectMetaData metaData;

    public ResultSetObjectFactory(IBeanFactory<T> beanFactory, ObjectMetaData metaData) {
        this.beanFactory = beanFactory;
        this.metaData = metaData;
    }

    @Override
    public Collection<T> translate(ResultSet source) {
        if (source == null) {
            return null;
        }

        Collection<T> objects = new ArrayList<>();

        Collection<FieldMetaData> fields = metaData.getFieldMetaData();

        while (true) {
            try {
                if (!source.next()) {
                    break;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            Map<String, Object> data = new HashMap<>();

            for (FieldMetaData field : fields) {
                // todo
            }

            objects.add(beanFactory.build(data));
        }

        return objects;
    }
}
