package com.postiveswing.pswing.compent;

import com.postiveswing.pswing.Constants.PConstants;
import com.postiveswing.pswing.compent.interfaces.FPS;
import com.postiveswing.pswing.compent.listers.MainMouseLister;
import com.postiveswing.pswing.compent.listers.MainMouseMotion;
import lombok.Data;

import javax.swing.*;
import java.awt.*;

/**
 * Author:li
 * 2022/2/5 15:38
 */
@Data
public abstract class PMainPanel extends JPanel implements Runnable {
    //帧率
    private int fps = 60;
    private long SLEEP_TIME = 1000 / fps;
    private Thread paintThread;
    //fps
    private boolean canDrawFps = true;
    //gameState
    private int gameState = PConstants.GAME_STATE_START;


    public PMainPanel() {
        iniLister();
    }

    @Override
    public void run() {
        while (true) {
            repaint();

            FPS.getFPS();
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void iniPaint() {
        paintThread = new Thread(this);

        SLEEP_TIME = 1000 / fps;
        paintThread.start();

    }

    private void iniLister() {

    }

    @Override
    public void paint(Graphics g2) {
        super.paint(g2);
        Graphics2D g = (Graphics2D) g2.create();


        selfPaint();
        if (gameState == PConstants.GAME_STATE_START) {
            selfLogic();
        }
        if (canDrawFps) {
            FPS.drawFps(g);
        }

    }

    /**
     * 逻辑型为
     */
    protected abstract void selfLogic();

    /**
     * 自定义绘制
     */
    public abstract void selfPaint();

    public void setFps(int fps) {
        if (fps <= 0 || fps > FPS.FPS_MAX) {
            throw new RuntimeException("fps设置异常");
        }
        this.fps = fps;

        if (paintThread != null) {
            paintThread.stop();
        }
        iniPaint();
    }


}
