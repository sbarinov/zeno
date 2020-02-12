package domain.zeno.core.bean;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import java.util.Map;

public interface IBeanFactory<T> {
    T build(Map<String, Object> data);
}
