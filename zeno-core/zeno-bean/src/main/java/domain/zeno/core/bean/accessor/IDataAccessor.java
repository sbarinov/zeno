package domain.zeno.core.bean.accessor;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.pattern.eip.ITranslator;

public interface IDataAccessor<S, T> extends ITranslator<S, T> {
    T getData(S source);

    @Override
    default T translate(S source) {
        return getData(source);
    }
}
