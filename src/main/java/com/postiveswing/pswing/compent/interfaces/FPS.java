package com.postiveswing.pswing.compent.interfaces;

import com.postiveswing.pswing.Constants.PConstants;

import java.awt.*;

/**
 * Author:li
 * 2022/1/12 20:51
 */
public class FPS {
    public static final int FPS_MAX = 120;
    private static long fpsTime = System.currentTimeMillis();
    private static int fpsCount;
    private static int fps;

    public static void drawFps(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.setFont(PConstants.GAME_FONT);
        g.drawString(fps + "", 20, 15);
    }

    public static void getFPS() {

        if (System.currentTimeMillis() - fpsTime >= 1000L) {
            fps = fpsCount;
            fpsCount = 0;
            fpsTime = System.currentTimeMillis();

        } else {
            fpsCount++;
        }
    }

}
