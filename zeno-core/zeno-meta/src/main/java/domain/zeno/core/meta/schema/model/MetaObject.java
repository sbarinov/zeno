package domain.zeno.core.meta.schema.model;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import java.util.Collection;

public class MetaObject {
    private String name;
    private MetaObjectType type;
    private Collection<MetaObjectField> fields;
    private Collection<MetaObjectRelation> relations;
}
