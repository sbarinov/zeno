package domain.zeno.core.ui.ne.render;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.ui.api.model.primitives.UiMenu;
import domain.zeno.core.ui.api.render.IComponentRenderer;

import javax.swing.*;

public class SwingMenuRenderer implements IComponentRenderer<UiMenu, JMenuBar> {
    @Override
    public JMenuBar render(UiMenu source) {
        JMenuBar target = new JMenuBar();

        target.setName(source.getId());
        target.setEnabled(source.isEnabled());

        return target;
    }
}
