package domain.zeno.core.ui.ne.render;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.ui.api.model.primitives.UiLabel;
import domain.zeno.core.ui.api.render.IComponentRenderer;

import javax.swing.*;

public class SwingLabelRenderer implements IComponentRenderer<UiLabel, JLabel> {
    @Override
    public JLabel render(UiLabel source) {
        JLabel target = new JLabel();

        target.setName(source.getId());
        target.setEnabled(source.isEnabled());

        target.setText(source.getValue());

        return target;
    }
}
