package com.itheima.snake;

import java.awt.*;

public class Grid {


    public void draw(Graphics2D g2d){

        if(Config.DEBUG_FLAG) {
            for (int i = 0; i < Config.ROW; i++) { //画每一行的线条
                g2d.drawLine(0, Config.GRID_SIZE * i, Config.SCREEN_WIDTH, Config.GRID_SIZE * i);
            }

            for (int i = 0; i < Config.COLOUM; i++) { //画每一列的线条
                g2d.drawLine(Config.GRID_SIZE * i, 0, Config.GRID_SIZE * i, Config.SCREEN_HEIGHT);
            }
        }

    }

}
