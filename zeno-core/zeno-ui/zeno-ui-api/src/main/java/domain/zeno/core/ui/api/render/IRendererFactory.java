package domain.zeno.core.ui.api.render;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.ui.api.model.primitives.AbstractUiComponent;

public interface IRendererFactory {
    <S extends AbstractUiComponent, T> IComponentRenderer<S, T> getRenderer(S source,
            Class<T> targetClass);
}
