package fanshedemo;

import fanshedemo.student;

import java.lang.reflect.Constructor;

public class fanshe02 {

    public static void main(String[] args) throws Exception {

        Class s = Class.forName("fanshedemo.student");

        Constructor decor = s.getDeclaredConstructor();

        decor.setAccessible(true);

        decor.newInstance();
    }
}
