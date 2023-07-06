package fanshedemo;

import javax.print.attribute.standard.JobOriginatingUserName;

public class student {

    private student(){

        System.out.println("私有构造方法被调用了");

    }
    static public student studentfangfa(){

        return new student();

    }


}
