package com.itheima.snake;

import com.itheima.game.GameEngine;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SnakeGameEngine extends GameEngine {
    Grid grid = new Grid();
//    Node node = new Node(5,5);
    Snake snake = new Snake();
    Apple apple = new Apple();
    Hard hard = new Hard();

    @Override
    public void updateLogic() {
        boolean headHaveApple = snake.headHaveApple(apple);
        boolean headHaveHard = snake.headHaveHard(hard);
        int keyCode = getCurrentPressedKeyCode();
        if(keyCode == KeyEvent.VK_RIGHT){
            snake.moveRight(headHaveApple,headHaveHard);
        }
        if(keyCode == KeyEvent.VK_LEFT){
            snake.moveLeft(headHaveApple,headHaveHard);
        }
        if(keyCode == KeyEvent.VK_UP){
            snake.moveUp(headHaveApple,headHaveHard);
        }
        if(keyCode == KeyEvent.VK_DOWN){
            snake.moveDown(headHaveApple,headHaveHard);
        }

        switch (snake.headDirection){
            case Direction.RIGHT:
                snake.moveRight(headHaveApple,headHaveHard);
                break;
            case Direction.LEFT:
                snake.moveLeft(headHaveApple,headHaveHard);
                break;
            case Direction.UP:
                snake.moveUp(headHaveApple,headHaveHard);
                break;
            case Direction.DOWN:
                snake.moveDown(headHaveApple,headHaveHard);
                break;
        }


    }


    @Override
    public void renderUI(Graphics2D g2d) {
        grid.draw(g2d); //画游戏的网格
        snake.draw(g2d);
        apple.draw(g2d);
        hard.draw(g2d);

    }
}
