/**
 * Let us simulate the process of converting fraction to decimal. Let us look at the part where we
 * have already figured out the integer part which is floor(numerator/denominator). Now we are left
 * with ( remainder = numerator%denominator ) / denominator. If you remember the process of
 * converting to decimal, at each step we do the following :
 * 
 * Multiply the remainder by 10. 
 * Append remainder / denominator to result. 
 * Remainder = remainder % denominator. 
 * 
 * At any moment, if remainder becomes 0, we are done.
 * 
 * However, when there is a recurring sequence, remainder never becomes 0. For example if you look
 * at 1/3, the remainder never becomes 0.
 * 
 * Below is one important observation : If we start with remainder ‘rem’ and if the remainder
 * repeats at any point of time, the digits between the two occurrence of ‘rem’ keep repeating.
 * 
 * So the idea is to store seen remainders in a map. Whenever a remainder repeats, we return the
 * sequence before the next occurrence.
 */
package com.buildingLogic.ms.numbers;

import java.util.HashMap;
import java.util.Map;

public class ReccuringSequenceFraction {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(findReccuringSequence(8, 3));
    System.out.println(findReccuringSequence(50, 22));
    System.out.println(findReccuringSequence(11, 2));

  }

  public static String findReccuringSequence(int numerator, int denominator) {
    String result = "";
    int remainder = numerator % denominator;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    if (numerator == 0 || remainder == 0) {
      return result;
    }

    while ((remainder != 0) && !map.containsKey(remainder)) {
      map.put(remainder, result.length());

      remainder *= 10;

      int rest = remainder / denominator;
      result = result + rest;

      remainder = remainder % denominator;
    }

    return (remainder == 0) ? "" : result;
  }

}
