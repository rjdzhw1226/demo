package com.stream;

public class NQueen01 {

  private int n;
  private long count;
  private int[] arr;
  private int nn;
  public NQueen01(int n){

    //this.n = n;
    nn = (1 << n) - 1;
    count = 0;
    arr = new int[n];
  }
  /** * row col i arr[i] * @param row * @param col * @return */
  public boolean Check(int row, int col){

    for(int i = 0; i < row; i++){

      if(col == arr[i] || Math.abs(row - i) == Math.abs(col - arr[i])) //在同一列或者在同一斜线。一定不在同一行
        return false;
    }
    return true;
  }
  //k 当前已走了多少个位置。 l 左斜线不能走的位置， r 右斜线不能走的位置。
  public void FindNQueen(int k, int l, int r){

    if(k == nn){

      count++;
      return;
    }
    int z = nn & (~(k | l | r));  //能走的位置， 和nn取并可以去掉前面多余的1
    while(z != 0){

      int index = z & (~z+1);   //最右边的一个1， 即要放皇后的位置。
      z -= index;   //去掉这个位置。
      FindNQueen(k | index, (l|index)<<1, (r|index)>>1);   //查找下一个。
    }
  }
  public static void main(String args[]){

    NQueen01 nQueen = new NQueen01(10);
    nQueen.FindNQueen(0,0,0);
    System.out.println(nQueen.count);
  }
}
