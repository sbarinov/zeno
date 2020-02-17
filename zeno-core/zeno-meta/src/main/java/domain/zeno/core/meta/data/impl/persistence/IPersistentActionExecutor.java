package domain.zeno.core.meta.data.impl.persistence;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.pattern.common.IProcessor;

public interface IPersistentActionExecutor<CONTEXT> {
    <RESULT> RESULT execute(IProcessor<CONTEXT, RESULT> action);
}
