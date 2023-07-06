package com.digui;

public class digui {
  public static void main(String[] args) {
    //System.out.println(digui(5));
    //System.out.println(digui01(100));
    //System.out.println(digui03(1));
    //System.out.println(digui04(7));
    System.out.println(d(319, 377));
  }
  public static int digui(int n){
    if(n==1){
      return 1;
    }else {
      return digui(n-1) * n;
    }
  }

  public static int digui01(int n){
    if(n==1){
      return 1;
    }else{
      return digui01(n-1) + n;
    }
  }
  /**
   * 每天吃一半，多一个
   * 1 n     n/2-1
   * 2 n/2-1 (n/2-1)/2-1
   * 公式
   * f(n) = f(n-1)/2-1
   * f(n)= 2*(f(n-1)+1)
   */
  public static int digui02(int n){
    if(n==1){
      return 1;
    }else{
      return 2 * (digui02(n-1)+1);
    }
  }
  public static int digui03(int n){
    if(n==10){return 1;}else{return 2* digui03(n+1)+2 ;}
  }
  /**
   * 一对兔子
   * 1 1
   * 2 1
   * 3 2
   * 4 3
   * 5 5
   * f(n) = f(n-2) + f(n-1)
   */
  public static int digui04(int n){
    if(n==1){
      return 1;
    }
    if(n==2){
      return 1;
    }
    return digui04(n-2) + digui04(n-1);
  }

  public static void digui05(int n , int r){
    int t =n%r;
    if(t!=0){
      n=r;
      r=t;
      digui05(n,r);
    }else{
      System.out.println(r);
    }
  }
  public static int d(int n,int r){
    if(n<=0 || r<=0){return 0;}     //如果传进来的参数小于0则返回0
    if(n%r==0){return r;}            //如果b能被a整除则b就是最大公约数
    else{ d(r,n%r);}
    return -1;
  }

  public static int digui06(int num){
    if(num == 1){
      return 1;
    }else if (num == 2){
      return 2;
    }else{
      return digui06(num - -1)+digui06(num - 2);
    }

  }
}
