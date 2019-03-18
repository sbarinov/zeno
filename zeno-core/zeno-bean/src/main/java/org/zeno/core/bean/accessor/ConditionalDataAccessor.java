package org.zeno.core.bean.accessor;

import java.util.function.Predicate;

public class ConditionalDataAccessor<S, T> implements IDataAccessor<S, T> {
    private final Predicate<S> predicate;
    private final IDataAccessor<S, T> delegate;

    public ConditionalDataAccessor(Predicate<S> predicate, IDataAccessor<S, T> delegate) {
        this.predicate = predicate;
        this.delegate = delegate;
    }

    @Override
    public T getData(S source) {
        T result;

        if (predicate.test(source)) {
            result = delegate.getData(source);
        } else {
            result = null;
        }

        return result;
    }
}
