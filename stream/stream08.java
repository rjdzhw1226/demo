package stream;


import java.util.Arrays;

/**
 * N*N皇后
 */
public class stream08 {
  private static int count = 0;
  private static int arrayCount = 0;
  private static int N = 6;

  public static void main(String[] args) {
    System.out.println("当前为"+N+"皇后");
    System.out.println();
    System.out.println("结果为count:"+init(N));
  }

  public static void print(char[][] array, int n){
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arrayCount++;
        if(array[i][j]=='Q'){
          //OutUtil.print(array[i][j]);
          System.out.print("  ");
        }else{
          System.out.print(array[i][j]);
          System.out.print("  ");
        }

        if (arrayCount%n==0){
          System.out.println();
        }
      }
    }
  }

  public static int init(int n){
    char[][] nQueen = new char[n][n];
    for (char[] chars : nQueen) {
      Arrays.fill(chars,'K');
    }
    TryPlay(nQueen,n,0);
    return count;
  }
  public static void TryPlay(char[][] checkBoard, int n, int row){
    if(row == n){
      count++;
      print(checkBoard,n);
      System.out.println();
      return;
    }
    for (int i = 0; i < n; i++) {
      if(checkPlay(n,i,checkBoard,row)){
        checkBoard[row][i] = 'Q';
        TryPlay(checkBoard,n,row+1);
        checkBoard[row][i] = 'K';
      }
    }

  }

  private static boolean checkPlay(int n, int i, char[][] checkBoard, int row) {
    //列检查
    for (int j = 0; j < row; ++j) {
      if (checkBoard[j][i] == 'Q') {
        return false;
      }
    }
    //对角线检查
    // 检查45度对角线
    for (int i1 = row - 1, j = i - 1; i1 >= 0 && j >= 0; i1--, j--) {
      if (checkBoard[i1][j] == 'Q') {
        return false;
      }
    }
    // 检查135度对角线
    for (int i2 = row - 1, j = i + 1; i2 >= 0 && j <= n - 1; i2--, j++) {
      if (checkBoard[i2][j] == 'Q') {
        return false;
      }
    }
    return true;
  }

}
