package domain.zeno.core.ui.ne.render;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.ui.api.model.primitives.AbstractUiComponent;
import domain.zeno.core.ui.api.model.primitives.UiButton;
import domain.zeno.core.ui.api.render.IComponentRenderer;
import domain.zeno.core.ui.api.render.IRendererFactory;
import domain.zeno.core.ui.api.model.UiForm;

import javax.swing.*;
import java.util.Map;

public class SwingFormRenderer implements IComponentRenderer<UiForm, JInternalFrame> {
    private final IRendererFactory rendererFactory;

    public SwingFormRenderer(IRendererFactory rendererFactory) {
        this.rendererFactory = rendererFactory;
    }

    @Override
    public JInternalFrame render(UiForm source) {
        JInternalFrame target = new JInternalFrame();

        target.setName(source.getId());
        target.setEnabled(source.isEnabled());

        target.setSize(source.getWidth(), source.getHeight());
        target.setResizable(source.isResizable());
        target.setIconifiable(source.isMinimizable());
        target.setMaximizable(source.isMaximizable());
        target.setClosable(source.isCloseable());

        Map<String, Integer> orderIndexes = source.getComponentOrder();

        for (AbstractUiComponent component : source.getComponents()) {
            String componentId = component.getId();

            if (UiButton.class.isAssignableFrom(component.getClass())) {
                JButton button =
                        rendererFactory.getRenderer(component, JButton.class).render(component);
                Integer index = orderIndexes.getOrDefault(componentId, -1);
                target.add(button, index);
            }
        }

        return target;
    }
}
