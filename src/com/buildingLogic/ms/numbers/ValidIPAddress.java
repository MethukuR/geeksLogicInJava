package com.buildingLogic.ms.numbers;

import java.util.Arrays;

public class ValidIPAddress {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }
  
  public boolean isValidAddress(String ipAddress) {
    String[] groups = ipAddress.split("\\.");
    
    if(groups.length != 4) {
      return false;
    }
    
    try {
      return Arrays.stream(groups)
          .filter(s -> s.length() > 0)
          .map(s -> Integer.parseInt(s))
          .filter(i -> (i >=0 && i <= 255))
          .count() == 4;
    }catch(NumberFormatException e) {
      throw new NumberFormatException();
    }
    
      
    
  }

}
