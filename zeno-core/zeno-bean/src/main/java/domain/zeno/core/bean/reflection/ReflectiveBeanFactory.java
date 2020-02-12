package domain.zeno.core.bean.reflection;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.bean.IBeanFactory;

import java.util.Map;

public class ReflectiveBeanFactory<T> implements IBeanFactory<T> {
    private final Class<T> clazz;

    public ReflectiveBeanFactory(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T build(Map<String, Object> data) {
        T instance;
        try {
            instance = clazz.newInstance();
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }

        // todo

        return instance;
    }
}
