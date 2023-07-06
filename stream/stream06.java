package com.stream;

public class stream06 {

  public int row = 8;
  private int col[] = new int[row];
  private static int count = 0;

  public static void main(String[] args) {

    stream06 stream06 = new stream06();
    stream06.putQueen(0);
    System.out.println(count);
  }

  public void putQueen(int i){
    if (i == row) {
      PrintResult();
      return;
    }
    for (int j = 0; j < row; j++) {
        col[i]=j;
        if (Judge(i)){
          putQueen(i+1);
        }
    }

  }

  private boolean Judge(int j) {
    for (int i = 0; i < j; i++) {
      if (col[i]==col[j] || Math.abs(i-j)==Math.abs(col[i]-col[j])){
        return false;
      }
    }
    return true;
  }

  private void PrintResult() {
    int count1 = 0;
    for (int i = 0; i < col.length; i++) {
      System.out.print(" "+"第"+i+"列的皇后下标"+col[i]+" ");
      //System.out.print(" " + col[i] + " ");
      count1++;
    }
    if (count1 == row) {
      System.out.println();
    }
    count++;
    System.out.println();
  }
}
