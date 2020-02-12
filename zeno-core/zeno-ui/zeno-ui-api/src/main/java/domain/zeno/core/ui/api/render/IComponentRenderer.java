package domain.zeno.core.ui.api.render;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.pattern.eip.ITranslator;
import domain.zeno.core.ui.api.model.primitives.AbstractUiComponent;

public interface IComponentRenderer<SOURCE extends AbstractUiComponent, TARGET>
        extends ITranslator<SOURCE, TARGET> {
    @Override
    default TARGET translate(SOURCE source) {
        return render(source);
    }

    TARGET render(SOURCE source);
}
