package domain.zeno.core.ui.ne.render;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.ui.api.render.IComponentRenderer;
import domain.zeno.core.ui.api.render.IRendererFactory;
import domain.zeno.core.ui.api.model.primitives.AbstractUiComponent;

public class SwingRendererFactory implements IRendererFactory {
    @Override
    public <S extends AbstractUiComponent, T> IComponentRenderer<S, T> getRenderer(S source,
            Class<T> targetClass) {
        return null;
    }
}
