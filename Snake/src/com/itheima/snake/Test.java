package com.itheima.snake;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        //队列, 理解成一个高级的数组
        LinkedList list = new LinkedList();

        list.addFirst("张三");//插队走到最前面
        list.addFirst("李四");
        list.addFirst("王五");
        list.addLast("钱七"); //插入队列的末尾

        System.out.println(list);

        list.removeFirst(); //把队伍的第一个人移除
        System.out.println(list);
        list.removeLast();///把队列的最后一个移除
        System.out.println(list);
    }
}
