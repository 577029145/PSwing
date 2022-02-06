package com.postiveswing.pswing;

import com.postiveswing.pswing.compent.PMainWindow;
import com.postiveswing.pswing.compent.listers.MainKeyLister;
import com.postiveswing.pswing.compent.listers.MainMouseLister;
import com.postiveswing.pswing.compent.listers.MainMouseMotion;
import jdk.jfr.internal.tool.Main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

/**
 * Author:li
 * 2022/2/5 16:01
 */
public class MainWindow {
    private static PMainWindow pMainWindow;

    public static void main(String[] args) {
        pMainWindow = new PMainWindow(new MainKeyLister());

        pMainWindow.addPanel(new MainPanel(), new MainMouseLister() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {

            }
        }, new MainMouseMotion() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
            }
        });
        pMainWindow.getMainPanel().setFps(20);
//        pMainWindow.getMainPanel().setCanDrawFps(false);
    }
}
