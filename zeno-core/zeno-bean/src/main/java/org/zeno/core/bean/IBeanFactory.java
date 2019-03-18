package org.zeno.core.bean;

import java.util.Map;

public interface IBeanFactory<T> {
    T build(Map<String, Object> data);
}
