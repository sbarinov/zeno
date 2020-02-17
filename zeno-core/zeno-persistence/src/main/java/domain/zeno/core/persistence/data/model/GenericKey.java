package domain.zeno.core.persistence.data.model;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.bean.supplier.ValueContainer;

import java.util.HashMap;
import java.util.Map;

public class GenericKey {
    private final Map<String, ValueContainer> fields = new HashMap<>();

    public Map<String, ValueContainer> getFields() {
        return new HashMap<>(fields);
    }
}
