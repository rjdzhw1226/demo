package rjd.heart;

import rjd.heart.util.GaussianBlur;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class heart01 extends JFrame {
  private static final int WIDTH = 900;
  private static final int HEIGHT = 800;

  private static final int WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
  private static final int WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

  public heart01(){
    //底色
    this.setBackground(Color.BLACK);
    //位置
    this.setLocation((WINDOW_WIDTH-WIDTH)/2,(WINDOW_HEIGHT-HEIGHT)/2);
    //大小
    this.setSize(WIDTH,HEIGHT);
    //布局
    this.setLayout(getLayout());
    //是否可见
    this.setVisible(true);
    //关闭方式
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }
    public void paint(Graphics g){
    double x,x1,y,y1,r;
    //绘制
      double z = 0.0;
      double size = 10;
      int jj = 0;
      while(true){
        Image image = this.createImage(WIDTH,HEIGHT);

        Graphics pic = image.getGraphics();
        if(jj%4==0){
          size=14;
        }else if(jj%3==0){
          size=14.5;
        }else if(jj%5==0){
          size=15;
        }else {
          size=15.5;
        }
        for (int ii = 30; ii > 0 ; ii--) {
          Color color = new Color(255 ,175 ,(int)(20*Math.random())+220);
          for (int i = 1; i < 400; i++) {
            int px = (int)(Math.random()*10);
            int py = (int)(Math.random()*10);
            x = 16*(Math.sin(z) * Math.sin(z)* Math.sin(z))*(size)+Math.pow((-1),px)*(Math.random()*Math.random()*20)+450;
            x1 = 16*(Math.sin(z) * Math.sin(z)* Math.sin(z))*(size)+450;
            if(x > x1){
              x1=x;
              x1+=Math.random()*15;
            }
            if(x <= x1){
              x1=x;
            }
            y = -(13*Math.cos(z)-5*Math.cos(2*z)-2*Math.cos(3*z)-Math.cos(4*z))*(size)+Math.pow((-1),py)*(Math.random()*Math.random()*20)+400;
            y1 = -(13*Math.cos(z)-5*Math.cos(2*z)-2*Math.cos(3*z)-Math.cos(4*z))*(size)+400;
            if(y > y1){
              y1=y;
              y1+=Math.random()*15;
            }
            if(y <= y1){
              y1=y;
            }
            z += (Math.PI/2.0)/100;
            pic.setColor(color);
            pic.fillOval((int) x1, (int) y1,2,2);
          }
          if(ii<3){
            //高斯模糊处理
            GaussianBlur gass = new GaussianBlur();
            BufferedImage bufferedImage = GaussianBlur.toBufferedImage(image);
            int height = bufferedImage.getHeight();
            int width = bufferedImage.getWidth();
            int[][] martrix = new int[3][3];
            int[] values = new int[9];
            for (int i = 0; i < width; i++)
              for (int j = 0; j < height; j++) {
                gass.readPixel(bufferedImage, i, j, values);
                gass.fillMatrix(martrix, values);
                bufferedImage.setRGB(i, j, gass.avgMatrix(martrix));
              }
            Image image1 = (Image) bufferedImage;
            g.drawImage(image1,0,0,this);
          }
        }
        jj++;
        if(jj>100){
          break;
        }
        try {
          Thread.sleep(400);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
  }

  public static void main(String[] args) {
    new heart01();
  }
}
