package com.itheima.snake;

import java.util.LinkedList;

public class Test2 {
    public static void main(String[] args) {
        LinkedList<Node> list = new LinkedList<Node>();
        list.add(new Node(6,4));//蛇头
        list.addLast(new Node(5,4));
        list.addLast(new Node(3,4));
        list.addLast(new Node(2,4));//蛇尾
        System.out.println(list);
    }
}
