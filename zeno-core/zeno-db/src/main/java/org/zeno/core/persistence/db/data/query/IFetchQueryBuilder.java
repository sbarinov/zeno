package org.zeno.core.persistence.db.data.query;

import org.zeno.core.persistence.data.model.FieldSet;

public interface IFetchQueryBuilder {
    String build(FieldSet fieldSet);
}
