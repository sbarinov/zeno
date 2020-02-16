package domain.zeno.core.persistence.schema;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.pattern.common.IProcessor;

public interface IGenericObjectActionFactory<CONTEXT, RESOURCE> {
    IProcessor<CONTEXT, Void> create(RESOURCE resource);

    IProcessor<CONTEXT, Void> update(RESOURCE resource);

    IProcessor<CONTEXT, Void> delete(String name);
}
