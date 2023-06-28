package com.itheima.snake;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Objects;

public class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g2d){
        g2d.fillRect(x*Config.GRID_SIZE,y*Config.GRID_SIZE,Config.GRID_SIZE,Config.GRID_SIZE);
    }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x && y == node.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
