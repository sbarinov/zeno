package domain.zeno.core.ui.ne.render;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.ui.api.model.primitives.UiCheckBoxField;
import domain.zeno.core.ui.api.render.IComponentRenderer;

import javax.swing.*;

public class SwingCheckBoxRenderer implements IComponentRenderer<UiCheckBoxField, JCheckBox> {
    @Override
    public JCheckBox render(UiCheckBoxField source) {
        JCheckBox target = new JCheckBox();

        target.setName(source.getId());
        target.setEnabled(source.isEnabled());

        target.setSelected(source.isSelected());

        return target;
    }
}
