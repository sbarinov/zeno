package org.zeno.core.persistence.db.data.provider.jdbc.statement;

import org.zeno.core.persistence.data.model.FieldSet;

import java.sql.PreparedStatement;

public interface IStatementBuilder {
    PreparedStatement prepare(String objectName, FieldSet fieldSet);
}
