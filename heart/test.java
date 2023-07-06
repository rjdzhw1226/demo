package rjd.heart;

public class test {
  public static void main(String[] args) {
    double x,y,z = 0.0;
    int size = 10;
    int px = (int)(Math.random()*10);
    int py = (int)(Math.random()*10);
    x = 16*(Math.sin(z) * Math.sin(z)* Math.sin(z))*(size)+Math.pow((-1),px);
    y = -(13*Math.cos(z)-5*Math.cos(2*z)-2*Math.cos(3*z)-Math.cos(4*z))*(size)+Math.pow((-1),py);
  }

}
