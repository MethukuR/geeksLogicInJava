package com.buildingLogic.ms.strings;

public class SumOfTwoLargeStringNumbers {

  public static void main(String[] args) {
    System.out.println(sum("3333311111111111", "44422222221111"));
    System.out.println(sum("3333311111111111", ""));
    System.out.println(sum("", "44422222221111"));
    System.out.println(sum("", ""));
  }
  
  private static String sum(String s1, String s2) {
    if(s1.isEmpty() && s2.isEmpty()) {
      return null;
    }
    
    if(s1.isEmpty()) {
      return s2;
    }
    
    if(s2.isEmpty()) {
      return s1;
    }
    
    int i = 0;
    int j = 0;
    int sum = 0;
    int carry = 0;
    String resultant = "";
    
    s1 = new StringBuffer(s1).reverse().toString();
    s2 = new StringBuffer(s2).reverse().toString();

    while(i < s1.length() || j < s2.length()) {
      sum = carry + ((i < s1.length()) ? (int)s1.charAt(i) - '0' : 0) + ((j < s2.length()) ? (int)s2.charAt(j) - '0' : 0);
      sum = sum%10;
      carry = sum/10;
      resultant += sum;
      ++i;
      ++j;
    }
    
    if(carry > 0) {
      resultant += carry;
    }
    
    resultant = new StringBuffer(resultant).reverse().toString();

    return resultant;
  }

}
