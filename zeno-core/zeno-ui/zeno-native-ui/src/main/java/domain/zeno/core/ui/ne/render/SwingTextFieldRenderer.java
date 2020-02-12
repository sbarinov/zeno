package domain.zeno.core.ui.ne.render;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import domain.zeno.core.ui.api.render.IComponentRenderer;
import domain.zeno.core.ui.api.model.primitives.UiTextField;

import javax.swing.*;

public class SwingTextFieldRenderer implements IComponentRenderer<UiTextField, JTextField> {
    private static final Integer DEFAULT_HEIGHT = 20;

    private final Integer height;

    public SwingTextFieldRenderer(Integer height) {
        this.height = height;
    }

    public SwingTextFieldRenderer() {
        this(DEFAULT_HEIGHT);
    }

    @Override
    public JTextField render(UiTextField source) {
        JTextField target = new JTextField();

        target.setName(source.getId());
        target.setEnabled(source.isEnabled());

        target.setSize(source.getWidth(), height);

        return target;
    }
}
