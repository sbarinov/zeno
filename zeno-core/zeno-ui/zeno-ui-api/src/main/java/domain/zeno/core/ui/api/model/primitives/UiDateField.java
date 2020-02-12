package domain.zeno.core.ui.api.model.primitives;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import java.time.LocalDate;

public class UiDateField extends AbstractUiComponent {
    private LocalDate value;

    public LocalDate getValue() {
        return value;
    }
}
