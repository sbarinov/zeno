package domain.zeno.core.ui.ne;

/*
 * COPYRIGHT_PLACEHOLDER
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.atomic.AtomicBoolean;

public class FormFactory {
    public static void main(String[] args) throws Exception {
        AtomicBoolean closed = new AtomicBoolean(false);

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(640, 480);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                closed.set(true);
            }
        });

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu 1");
        JMenuItem menuItem = new JMenuItem("Menu 1 Item 1");

        menu.add(menuItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        JDesktopPane desktop = new JDesktopPane();
        frame.setContentPane(desktop);

        JInternalFrame internalFrame = new JInternalFrame("Item 1", true, true, true, true);
        internalFrame.setSize(320, 240);
        desktop.add(internalFrame);

        frame.setVisible(true);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                internalFrame.setVisible(true);
            }
        });

        while (!Thread.currentThread().isInterrupted() && !closed.get()) {
            Thread.sleep(1000L);
        }

        System.out.println(closed.get());
    }
}
