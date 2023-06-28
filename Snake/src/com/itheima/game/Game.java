package com.itheima.game;

import com.itheima.snake.Config;

import javax.swing.*;
import java.awt.*;

/**
 * 大牛程序员写的游戏的公共类 <p></p>
 * 使用Game.init()方法初始化游戏<p></p>
 * 使用Game.gameOver()方法退出游戏<p></p>
 */
public class Game extends JPanel {


    private GameEngine engine;
    private Graphics2D g2d;
    private static JFrame frame;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        engine.renderUI(g2d);
    }

    /**
     * 使用游戏引擎初始化游戏的方法
     * @param title 游戏窗体的标题
     * @param width 游戏窗体的宽度
     * @param height 游戏窗体的高度
     * @param engine 游戏引擎
     */
    public static void init(String title, int width, int height, GameEngine engine){
        frame = new JFrame(title);
        Game game = new Game();
        game.engine = engine;
        game.addKeyListener(engine.listener);
        game.setFocusable(true);
        game.setPreferredSize(new Dimension(width, height));
        frame.add(game);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            engine.updateLogic();
            game.repaint();
            try {
                Thread.sleep(Config.sleep_time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 显示退出游戏对话框的方法
     * @param message 对话框提示的消息
     * @param title 对话框提示的标题
     */
    public static void gameOver(String message,String title) {
        JOptionPane.showMessageDialog(frame, message, title, JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }
}



      