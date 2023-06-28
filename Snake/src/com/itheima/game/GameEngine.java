package com.itheima.game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 由大牛程序员编写的游戏引擎的抽象模板类<p></p>
 * 需要调用者实现两个抽象方法， 更新逻辑方法updateLogic<p></p>
 * 更新ui方法 renderUI<p></p>
 */
public abstract class GameEngine {
    KeyListener listener;
    private int currentPressedKeyCode;

    /**
     * 构造方法，创建出游戏引擎
     */
    public  GameEngine(){
        this.listener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                currentPressedKeyCode = e.getKeyCode();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                currentPressedKeyCode = -1;
            }
        };
    }

    /**
     * 获取当前用户的按键代码 按键代码的定义在KeyEvent对象中定义
     * @return 返回KeyEvent的按键代码
     */
    public int getCurrentPressedKeyCode(){
        return  currentPressedKeyCode;
    }

    /**
     * 根据用户行为或者游戏的时间更新游戏的逻辑
     */
    public abstract void updateLogic();

    /**
     * 根据用户需求更新绘制图形化界面的内容<p></p>
     * 示例代码，绘制矩形：    g2d.fillRect(左上角x的坐标, 左上角y的坐标, 矩形的宽度, 矩形的高度);<p></p>
     * 示例代码：绘制椭圆形：  g2d.fillOval(椭圆外包裹矩形左上角x的坐标, 椭圆外包裹矩形y的坐标, 要填充椭圆形的宽度, 要填充椭圆形的高度);<p></p>
     * @param g2d
     */
    public abstract void renderUI(Graphics2D g2d);


}
