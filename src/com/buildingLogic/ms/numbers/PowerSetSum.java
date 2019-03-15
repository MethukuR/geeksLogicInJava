package com.buildingLogic.ms.numbers;

public class PowerSetSum {
  public int findPowerSetSum(int input) {
    if( input == 0 || input == 1) {
      return input;
    }
    
    int sum = 0;
    for (int i = 0; i < (1 << input); i++) {
      StringBuffer binaryString = new StringBuffer(Integer.toBinaryString(i));
      binaryString.reverse();
      for (int j = 0; j < binaryString.length(); j++) {
        if(binaryString.charAt(j) == '1') {
          sum += (j+1);
        }
      }
    }
    return sum;
  }
}
