package domain.zeno.core.bean.builder;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.bean.IBeanFactory;

import java.util.Map;

public class BuilderBeanFactory<T, B> implements IBeanFactory<T> {
    private final IBeanFactory<B> delegate;

    public BuilderBeanFactory(IBeanFactory<B> delegate) {
        this.delegate = delegate;
    }

    @Override
    public T build(Map<String, Object> data) {
        B builder = delegate.build(data);
        // todo call builder.build();
        return null;
    }
}
