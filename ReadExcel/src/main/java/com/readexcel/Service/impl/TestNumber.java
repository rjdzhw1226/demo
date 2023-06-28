package com.readexcel.Service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TestNumber {
  public static void main(String[] args) {
    //double v = getrandomDouble(1.7, 2.5);
    //System.out.println(v);
    List<Double> weight = getWeight(12,20,1.0);
    System.out.println(weight);
  }

  public static int getrandom(int MIN, int MAX) {
    Random random = new Random();
    return random.nextInt(MAX - MIN + 1) + MIN;
  }

  public static double getrandomDouble(double MIN, double MAX) {
    Random rand = new Random();
    double result = MIN + (rand.nextDouble() * (MAX - MIN));
    result = (double) Math.round(result * 10) / 10;
    return result;
  }

  public static List<Double> getWeight(int num, int max, double min) {
    List<Double> result = new ArrayList<Double>();
    if (num == 1) {
      result.add((double)max);
      return result;
    } else {
      double num1 = getrandomDouble(min, (max / num + 1));
      result.add(num1);
      double total = max;
      for (int i = 1; i < num; i++) {
        total = total - num1;
        while (total < min) {
          double maxc = Collections.max(result);
          result.set(result.indexOf(maxc), min);
          double s = result.stream().map(e -> e).reduce(Double::sum).get();
          total = max - s;
        }
        if (i != num - 1) {
          num1 = getrandomDouble(min, total);
          result.add(num1);
        } else {
          result.add(total);
        }
      }
    }
    return result;
  }
}
