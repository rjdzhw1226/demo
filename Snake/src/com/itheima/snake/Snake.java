package com.itheima.snake;

import com.itheima.game.Game;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 蛇类
 */
public class Snake {
    LinkedList<Node> snake; //队列
    int headDirection = Direction.RIGHT; //1,上 2下,3左,4右

    public Snake() {
        snake = new LinkedList<Node>();
        snake.add(new Node(6,4));//蛇头
        snake.addLast(new Node(5,4));
        snake.addLast(new Node(4,4));
        snake.addLast(new Node(3,4));
        snake.addLast(new Node(2,4));//蛇尾
    }

    public void moveRight(boolean headHaveApple,boolean headHaveHard){
        if(headDirection == Direction.LEFT){
            System.out.println("蛇头向左,不能右移");
            return;
        }
        headDirection = Direction.RIGHT;
        //右边加一个头,尾巴直接删掉
        Node newHead = new Node( snake.getFirst().x+1, snake.getFirst().y);

        if(snake.contains(newHead)){
            System.out.println("自己咬着自己了");
            Game.gameOver("游戏失败","再接再厉");
        }

        if(snake.getFirst().x >= (Config.SCREEN_WIDTH/Config.GRID_SIZE)){
          System.out.println("碰到边界了");
          Game.gameOver("游戏失败","再接再厉");
        }

        snake.addFirst(newHead);//装一个新头
        if(headHaveApple){
            //蛇要边长, 尾巴就不需要删除了
        }else {
            snake.removeLast();//删除掉尾巴
        }
      if(headHaveHard){
        System.out.println("碰到障碍了");
        Game.gameOver("游戏失败","再接再厉");
      }
    }
    public void moveLeft(boolean headHaveApple,boolean headHaveHard){
        if(headDirection == Direction.RIGHT){
            System.out.println("蛇头向右,不能左移");
            return;
        }
        headDirection = Direction.LEFT;
        //左边加一个头,尾巴直接删掉
        Node newHead = new Node( snake.getFirst().x-1, snake.getFirst().y);
        if(snake.contains(newHead)){
            System.out.println("自己咬着自己了");
            Game.gameOver("游戏失败","再接再厉");
        }

        if(snake.getFirst().x <= 0){
          System.out.println("碰到边界了");
          Game.gameOver("游戏失败","再接再厉");
        }
        snake.addFirst(newHead);//装一个新头

        if(headHaveApple){
            //蛇要边长, 尾巴就不需要删除了
        }else {
            snake.removeLast();//删除掉尾巴
        }
      if(headHaveHard){
        System.out.println("碰到障碍了");
        Game.gameOver("游戏失败","再接再厉");
      }
    }
    public void moveUp(boolean headHaveApple,boolean headHaveHard){
        if(headDirection == Direction.DOWN){
            System.out.println("蛇头向下,不能上移");
            return;
        }
        headDirection = Direction.UP;
        //上边加一个头,尾巴直接删掉
        Node newHead = new Node( snake.getFirst().x, snake.getFirst().y-1);
        if(snake.contains(newHead)){
            System.out.println("自己咬着自己了");
            Game.gameOver("游戏失败","再接再厉");
        }

        if(snake.getFirst().y <= 0){
          System.out.println("碰到边界了");
          Game.gameOver("游戏失败","再接再厉");
        }
        snake.addFirst(newHead);//装一个新头
        if(headHaveApple){
            //蛇要边长, 尾巴就不需要删除了
        }else {
            snake.removeLast();//删除掉尾巴
        }
      if(headHaveHard){
        System.out.println("碰到障碍了");
        Game.gameOver("游戏失败","再接再厉");
      }
    }
    public void moveDown(boolean headHaveApple,boolean headHaveHard){
        if(headDirection == Direction.UP){
            System.out.println("蛇头向上,不能下移");
            return;
        }
        headDirection = Direction.DOWN;
        //下边加一个头,尾巴直接删掉
        Node newHead = new Node( snake.getFirst().x, snake.getFirst().y+1);
        if(snake.contains(newHead)){
            System.out.println("自己咬着自己了");
            Game.gameOver("游戏失败","再接再厉");
        }

        if(snake.getFirst().y >= (Config.SCREEN_WIDTH/Config.GRID_SIZE)){
          System.out.println("碰到边界了");
          Game.gameOver("游戏失败","再接再厉");
        }
        snake.addFirst(newHead);//装一个新头
        if(headHaveApple){
            //蛇要边长, 尾巴就不需要删除了
        }else {
            snake.removeLast();//删除掉尾巴
        }
      if(headHaveHard){
        System.out.println("碰到障碍了");
        Game.gameOver("游戏失败","再接再厉");
      }
    }

    public void draw(Graphics2D g2d){
        g2d.drawString("蛇的长度:"+snake.size(),50,100);
        for (int i = 0; i < snake.size() ; i++) {
            if(i==0){
                //蛇头
                g2d.setColor(Color.GREEN);
            }else{
                //蛇身子
                g2d.setColor(Color.BLACK);
            }
            snake.get(i).draw(g2d);
        }
    }

    /**
     * 检查蛇头上有没有苹果
     * @param apple 被检查的苹果
     * @return
     */
    public boolean headHaveApple(Apple apple){
        if((snake.getFirst().x == apple.getX()) && (snake.getFirst().y==apple.getY())){
            //蛇吃到苹果了
            //通知这个苹果再新的位置产生一个
            apple.generateNext();
            return true;
        }else{
            return false;
        }
    }

  public boolean headHaveHard(Hard hard){
    LinkedList<Node> nodes = hard.getAll();
    for (Node node : nodes) {
      if((snake.getFirst().x == node.x) && (snake.getFirst().y==node.y)){
        return true;
      }
    }
    return false;
  }
}
