package com.buildingLogic.ms.strings;

public class StringCompression {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }
  
  public String compressString(String s) {
    
    int strLen = s.length();
    if(strLen == 0 ) {
      return s;
    }
    
    if(strLen == 1) {
      return s+1;
    }
    
    String compressedString = "";
    int count = 1;
    
    for (int i = 0; i < strLen-1; i++) {
      if(s.charAt(i) == s.charAt(i+1)) {
        ++count;
      }else {
        compressedString = compressedString + s.charAt(i) + count;
        count = 1;
      }
    }
    
    compressedString = compressedString + s.charAt(strLen-1) +count;
    
    return (compressedString.length() < strLen) ? compressedString : s;
  }

}
