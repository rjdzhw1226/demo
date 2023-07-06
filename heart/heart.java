package rjd.heart;

import java.nio.ByteBuffer;

import static java.lang.Math.*;

public class heart {
  public static void main(String[] args) {
    ByteBuffer byteBuffer = ByteBuffer.allocate(6);
    heart2();
  }
  public static  void heart2(){
    double x,y,a;
    char s[]=new char[]{'I',' ','l','o','v','e',' ','y','o','u','!'};
    int index=0;
    for(y=1.3f;y>-1.1f;y-=0.06f){
      index=0;
      for(x=-1.1f;x<=1.1f;x+=0.025f){
        double result=x*x+pow((5.0*y/4.0-sqrt(abs(x))),2);
        if(result<=1){
          System.out.print((s[index]));
          index=(index+1)%11;
        }
        else{
          System.out.print(' ');
        }
      }
      System.out.println(" ");
    }
  }


}
