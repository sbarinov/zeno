package domain.zeno.core.ui.api.model;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.ui.api.model.primitives.AbstractUiComponent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UiComplexComponent extends AbstractUiComponent {
    private Collection<AbstractUiComponent> components = new ArrayList<>();
    private Map<String, Integer> componentOrder = new HashMap<>();

    public Collection<AbstractUiComponent> getComponents() {
        return new ArrayList<>(components);
    }

    public Map<String, Integer> getComponentOrder() {
        return new HashMap<>(componentOrder);
    }
}
