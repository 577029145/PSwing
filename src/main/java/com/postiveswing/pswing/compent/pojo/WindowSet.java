package com.postiveswing.pswing.compent.pojo;

import lombok.Data;

/**
 * Author:li
 * 2022/2/5 15:25
 */
@Data
public class WindowSet {
    private String title = "MainWindow";

    private int gameFrameWidth = 900, gameFrameHeight = 600;

    private boolean resizable = false;

    private boolean visible = true;


}
