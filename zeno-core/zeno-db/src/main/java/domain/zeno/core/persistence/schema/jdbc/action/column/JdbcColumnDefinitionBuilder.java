package domain.zeno.core.persistence.schema.jdbc.action.column;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.persistence.schema.model.Column;
import domain.zeno.core.persistence.schema.model.ColumnConstraint;
import domain.zeno.core.persistence.schema.model.ColumnType;

public class JdbcColumnDefinitionBuilder {
    private String type;
    private Integer size;
    private boolean nullable;
    private Object defaultValue;

    public JdbcColumnDefinitionBuilder type(String type) {
        this.type = type;
        return this;
    }

    public JdbcColumnDefinitionBuilder size(Integer size) {
        this.size = size;
        return this;
    }

    public JdbcColumnDefinitionBuilder nullable(boolean nullable) {
        this.nullable = nullable;
        return this;
    }

    public JdbcColumnDefinitionBuilder defaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    public String build() {
        StringBuilder definition = new StringBuilder();

        definition.append(type);

        if (size != null && size > 0) {
            definition.append("(").append(size).append(")");
        }

        if (!Boolean.TRUE.equals(nullable)) {
            definition.append(" NOT NULL");
        }

        if (defaultValue != null) {
            definition.append(" DEFAULT ").append(defaultValue);
        }

        return definition.toString();
    }

    public JdbcColumnDefinitionBuilder type(ColumnType columnType) {
        if (columnType != null) {
            if (columnType.getType() != null) {
                String type;
                switch (columnType.getType()) {
                    case DATE:
                        type = "DATE";
                        break;
                    case NUMBER:
                        type = "NUMBER";
                        break;
                    case BLOB:
                        type = "BLOB";
                        break;
                    case CLOB:
                        type = "CLOB";
                        break;
                    default:
                    case STRING:
                        type = "VARCHAR2";
                        break;
                }
                type(type);
            }

            size(columnType.getSize());
        }

        return this;
    }

    public String build(Column column) {
        type(column.getType());

        ColumnConstraint constraint = column.getConstraint();
        if (constraint != null) {
            nullable(constraint.getNullable());
        }

        Object defaultValue = column.getDefaultValue();
        if (defaultValue != null) {
            defaultValue(defaultValue);
        }

        return build();
    }
}
