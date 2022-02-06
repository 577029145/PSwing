package com.postiveswing.pswing.compent;

import com.postiveswing.pswing.compent.listers.MainKeyLister;
import com.postiveswing.pswing.compent.listers.MainMouseLister;
import com.postiveswing.pswing.compent.listers.MainMouseMotion;
import com.postiveswing.pswing.compent.pojo.WindowSet;
import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Author:li
 * 2022/2/5 15:19
 */
@Data
public class PMainWindow extends JFrame {
    private MainKeyLister mainKeyLister;

    public PMainWindow(MainKeyLister mainKeyLister) {
        this.mainKeyLister = mainKeyLister;
        windowSet = new WindowSet();
        init();
    }

    public PMainWindow(MainKeyLister mainKeyLister, WindowSet windowSet) {
        this.mainKeyLister = mainKeyLister;
        this.windowSet = windowSet;
        init();
    }

    private void init() {
        if (windowSet != null) {
            setTitle(windowSet.getTitle());

            setSize(windowSet.getGameFrameWidth(), windowSet.getGameFrameHeight());

            setLocation(Toolkit.getDefaultToolkit().getScreenSize().width - windowSet.getGameFrameWidth() >> 1,
                    Toolkit.getDefaultToolkit().getScreenSize().height - windowSet.getGameFrameHeight() >> 1);

            setResizable(windowSet.isResizable());

            setVisible(windowSet.isVisible());

            setSize(getWidth(), getHeight() + getInsets().top + 8);
        }
        addLister();
    }


    private void addLister() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.addKeyListener(mainKeyLister);
    }

    private WindowSet windowSet = new WindowSet();

    /**
     * 绘制 PMainPanel
     *
     * @param panel
     */
    public void addPanel(PMainPanel panel, MainMouseLister mainMouseLister, MainMouseMotion mainMouseMotion) {
        add(panel);
        this.mainPanel = panel;
        panel.addMouseListener(mainMouseLister);
        panel.addMouseMotionListener(mainMouseMotion);
        panel.iniPaint();
    }

    private PMainPanel mainPanel;
}
