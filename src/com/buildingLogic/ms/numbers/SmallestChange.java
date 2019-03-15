package com.buildingLogic.ms.numbers;

import java.util.Arrays;

public class SmallestChange {

  public static void main(String[] args) {

  }
  public int findMinCoins(int amount, int[] coins) {
    int[] cache = new int[amount];
    Arrays.fill(cache, -1);
    return findMinCoins(amount, coins, cache);
  }
  public int findMinCoins(int amount, int[] coins, int[] cache) {
    if(amount == 0) {
      return 0;
    }
    
    int min = amount;
    
    int c = 0;
    for (int coin : coins) {
      if(amount-coin >= 0) {
        if(cache[amount-coin] >= 0) {
          c = cache[amount-coin];
        }else {
          c = findMinCoins(amount-coin, coins, cache);
          cache[amount-coin] = c;
        }
        if(min > c+1) {
          min = c+1;
        }
      }
    }
    return min;
  }

}
