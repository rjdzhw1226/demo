package rjd.heart;

import java.awt.Color;

import java.awt.Graphics;

import javax.swing.JFrame;



public class DrawSin extends JFrame {



  private static int SCALE_X = 40; // X轴缩放倍数

  private static int SCALE_Y = 100; // Y轴缩放倍数

  private static int ORIGIN_X = 50; // 原点X

  private static int ORIGIN_Y = 0; // 原点Y

  private static int END_ARC = 360 * 2; // 画多长



  public void paint(Graphics g) {

    double ox = 0, oy = 0, x = 0, y = 0, arc = 0;

    super.paint(g);



    ORIGIN_Y = this.getHeight() / 2;



    // 画坐标轴

    g.drawLine(ORIGIN_X, ORIGIN_Y, this.getWidth(), ORIGIN_Y); // 横轴

    g.drawLine(ORIGIN_X, 0, ORIGIN_X, this.getHeight()); // 纵轴

    // 每90度画个标尺

    for (int i = 0; i < END_ARC; i += 90) {

      arc = Math.PI * i * 2 / 360;

      x = ORIGIN_X + arc * SCALE_X;

      g.drawLine((int) x, ORIGIN_Y - 10, (int) x, ORIGIN_Y + 10);

    }



    // 画正弦曲线

    g.setColor(Color.RED);

    for (int i = 0; i < END_ARC; i += 10) {

      arc = Math.PI * i * 2 / 360;

      x = ORIGIN_X + arc * SCALE_X;

      y = ORIGIN_Y + Math.sin(arc) * SCALE_Y;

      if (arc > 0) {

        g.drawLine((int) ox, (int) oy, (int) x, (int) y);

      }

      ox = x;

      oy = y;

    }

  }



  public static void main(String[] args) {

    DrawSin wnd = new DrawSin();

    wnd.setSize(600, 500);

    wnd.setVisible(true);

  }

}
