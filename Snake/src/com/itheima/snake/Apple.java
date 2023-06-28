package com.itheima.snake;

import java.awt.*;
import java.util.Random;

public class Apple {

    public int getX(){
        return apple.x;
    }
    public int getY(){
        return apple.y;
    }

    Random random = new Random();
    Node apple;

    public Apple() {
        apple = new Node(random.nextInt(Config.COLOUM),random.nextInt(Config.ROW));
    }

    public void draw(Graphics2D g2d){
        g2d.setColor(Color.red);
        apple.draw(g2d);
        g2d.setColor(Color.BLACK);
    }
    //在新的位置产生一个苹果
    public void generateNext() {
        apple = new Node(random.nextInt(Config.COLOUM),random.nextInt(Config.ROW));
    }
}
