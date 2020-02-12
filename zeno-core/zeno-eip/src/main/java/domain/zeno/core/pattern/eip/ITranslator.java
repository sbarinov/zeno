package domain.zeno.core.pattern.eip;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.pattern.common.IProcessor;

public interface ITranslator<SOURCE, TARGET> extends IProcessor<SOURCE, TARGET> {
    @Override
    default TARGET process(SOURCE source) {
        return translate(source);
    }

    TARGET translate(SOURCE source);
}
