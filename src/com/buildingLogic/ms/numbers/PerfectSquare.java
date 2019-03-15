package com.buildingLogic.ms.numbers;

public class PerfectSquare {

  public static void main(String[] args) {
    System.out.println(findPerfectSquare(15, 0.0005));
  }

  private static String findPerfectSquare(double number, double precision) {
    if (number == 0) {
      return "0.000";
    }

    boolean isNegative = number < 0;

    double start = 1;
    double end = Math.abs(number);

    double mid = start + (end - start) / 2;
    double prevMid = 0;
    double diff = Math.abs(mid - prevMid);
    while (mid * mid != number && diff > precision) {
      if (mid * mid < number) {
        start = mid ;
      } else {
        end = mid;
      }
      prevMid = mid;
      mid = start + (end - start) / 2;
      diff = Math.abs(mid - prevMid);
    }

    return mid + (isNegative ? "i" : "");
  }

}
