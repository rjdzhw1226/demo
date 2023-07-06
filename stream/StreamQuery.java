package com.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamQuery {
  public static void main(String[] args) {
    List<List<Integer>> lists = EightQueen(4, 16);
    System.out.println(lists);
  }

  public static List<List<Integer>> EightQueen(int col, int boardSize){
    List<List<Integer>> solutions = new ArrayList<>();
    if (col == 1) {
      for (int i = 1; i <= boardSize ; i++) {
        List<Integer> init = new ArrayList<>();
        init.add(i);
        solutions.add(init);
      }
      return solutions;
    }
    List<List<Integer>> restQueenSolutions = EightQueen(col-1,boardSize);
    return restQueenSolutions.stream()
      .map(restQueens -> tryPlay(restQueens,boardSize))
      .flatMap(tryPlaySolutions -> tryPlaySolutions.stream())
      .filter(t -> checkTryPlay(t))
      .collect(Collectors.toList());
  }

  private static boolean checkTryPlay(List<Integer> queens) {
    int row = queens.size();
    int col = queens.get(row - 1);
    for (int i = 0; i < row - 1; i++) {
      int qRow = i;
      int qCol = queens.get(i);

      // 检查是否在同一列或对角线上
      if (qCol == col || Math.abs(qRow - row) == Math.abs(qCol - col)) {
        return false;
      }
    }
    return true;
  }

  private static List<List<Integer>> tryPlay(List<Integer> queens, int boardSize) {
    List<List<Integer>> solutions = new ArrayList<>();
    for (int col = 1; col <= boardSize; col++) {
      List<Integer> newQueen = new ArrayList<>(queens);
      newQueen.add(col);
      solutions.add(newQueen);
    }
    return solutions;
  }
}
