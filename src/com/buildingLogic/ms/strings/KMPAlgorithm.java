package com.buildingLogic.ms.strings;

public class KMPAlgorithm {

  public static void main(String[] args) {
    System.out.println(patternMatch("ABABDABACDABABCABAB", "ABABCABAB"));
    System.out.println(patternMatch("ABABDABACDABABCABAB", "xyz"));
    System.out.println(patternMatch("", "xyz"));
    System.out.println(patternMatch("cde", ""));
    System.out.println(patternMatch("cde", "sdfgh"));

  }
  
  public static int patternMatch(String input, String pattern) {
    int patternLen = pattern.length();
    int inputLen = input.length();
    if(pattern.isEmpty() || input.isEmpty() || patternLen > inputLen) {
      return -1;
    }
    
    int[] lps = computeLPS(pattern);
    
    /*for (int i = 0; i < lps.length; i++) {
      System.out.print(lps[i] + "\t");
    }*/
    
    int i = 0;
    int j = 0;
    int startIndex = -1;
    while( i < inputLen) {
      if(input.charAt(i) == pattern.charAt(j)) {
        ++i;
        ++j;
      }
      
      if( j == patternLen-1) {
        startIndex = (i - j);
        break;
      }else if( i < inputLen && input.charAt(i) != pattern.charAt(j)) {
        if( j != 0) {
          j = lps[j-1];
        }else {
          ++i;
        }
      }
    }
    
    return startIndex;
  }

  private static int[] computeLPS(String pattern) {
    int patternLen = pattern.length();

    int[] lps = new int[patternLen];
    lps[0] = 0;
    
    int i = 1;
    int len = 0;
    
    while(i < patternLen) {
     if(pattern.charAt(i) == pattern.charAt(len)) {
       ++len;
       lps[i] = len;
       ++i;
     }else {
       if(len != 0) {
         len = lps[len-1];
       }else {
         ++i;
       }
     }
    }
    
    return lps;
  }

}
