package domain.zeno.core.ui.ne.render;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.ui.api.model.primitives.UiButton;
import domain.zeno.core.ui.api.render.IComponentRenderer;

import javax.swing.*;

public class SwingButtonRenderer implements IComponentRenderer<UiButton, JButton> {
    @Override
    public JButton render(UiButton source) {
        JButton target = new JButton();

        target.setName(source.getId());
        target.setEnabled(source.isEnabled());

        target.setText(source.getText());
        target.setSize(source.getWidth(), source.getHeight());

        return target;
    }
}
