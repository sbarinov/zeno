package domain.zeno.core.persistence.db.schema.generic;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.pattern.common.IProcessor;

public interface IGenericObjectActionFactory<INPUT, RESOURCE> {
    IProcessor<INPUT, Void> create(RESOURCE resource);

    IProcessor<INPUT, Void> update(RESOURCE resource);

    IProcessor<INPUT, Void> delete(String name);
}
