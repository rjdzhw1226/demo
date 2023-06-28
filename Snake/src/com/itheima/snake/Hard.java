package com.itheima.snake;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Hard {

  Random random = new Random();
  LinkedList<Node> hard;
  public int getrandomMine(int width){
    return random.nextInt(width);
  }
  public Hard() {
    int i = getrandomMine(Config.COLOUM);
    int j = getrandomMine(Config.ROW);
    hard = new LinkedList<Node>();
    hard.add(new Node(i,j));
    hard.addLast(new Node(i+1,j));
    hard.addLast(new Node(i+1,j+1));
    hard.addLast(new Node(i,j+1));
  }

  public void draw(Graphics2D g2d){
    g2d.setColor(Color.GRAY);
    for (int i = 0; i < hard.size(); i++) {
      hard.get(i).draw(g2d);
    }
  }

  public LinkedList<Node> getAll(){
    LinkedList<Node> nodes = new LinkedList<>();
    for (int i = 0; i < hard.size(); i++) {
      if(i == 0){
        nodes.add(hard.get(i));
      }else{
        nodes.addLast(hard.get(i));
      }
    }
    return nodes;
  }
  public void generateNext() {

  }

}
