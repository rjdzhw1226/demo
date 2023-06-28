package com.itheima.snake;

import com.itheima.game.Game;

public class SnakeGame {
    public static void main(String[] args) {
        Game.init("黑马贪吃蛇",Config.SCREEN_WIDTH,Config.SCREEN_HEIGHT,new SnakeGameEngine());
    }
}
