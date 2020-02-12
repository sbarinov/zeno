package domain.zeno.core.ui.api.model.primitives;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import java.io.Serializable;

public abstract class AbstractUiComponent implements Serializable {
    private String id;
    private String contextId;
    private boolean enabled;

    public String getId() {
        return id;
    }

    public String getContextId() {
        return contextId;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
