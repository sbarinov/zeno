package domain.zeno.core.ui.api.model;

/*
 * COPYRIGHT_PLACEHOLDER
 */

public class UiForm extends UiComplexComponent {
    private Integer width;
    private Integer height;
    private String title;
    private boolean resizable;
    private boolean minimizable;
    private boolean maximizable;
    private boolean closeable;

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public String getTitle() {
        return title;
    }

    public boolean isResizable() {
        return resizable;
    }

    public boolean isMinimizable() {
        return minimizable;
    }

    public boolean isMaximizable() {
        return maximizable;
    }

    public boolean isCloseable() {
        return closeable;
    }
}
