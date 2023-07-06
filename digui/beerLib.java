package com.digui;

public class beerLib {

  public static int totalCount;
  public static int totalBottleCount;
  public static int totalBeerLibCount;

  public static void main(String[] args) {
    buy(10);
    System.out.println("总瓶数：" + totalCount);
    System.out.println("总瓶子数：" + totalBottleCount);
    System.out.println("总瓶盖数：" + totalBeerLibCount);
  }

  public static void buy(int money){

    //计算立马能买的瓶数
    int buyNumber = money/2;
    //总瓶数
    totalCount += buyNumber;

    //记录本轮总的瓶子和盖子
    int BottleCount = totalBottleCount + buyNumber;
    int BeerLibCount = totalBeerLibCount + buyNumber;

    //换过来的钱
    int allMoney = 0;
    //记录剩的瓶子
    if (BottleCount >= 2) {
      allMoney += (BottleCount/2)*2;
    }
    totalBottleCount = BottleCount % 2;

    //记录剩的盖子
    if (BeerLibCount >= 4) {
      allMoney +=(BeerLibCount/4)*2;
    }
    totalBeerLibCount = BeerLibCount % 4;

    //再去买
    if (allMoney >= 2) {
      buy(allMoney);
    }
  }
}
