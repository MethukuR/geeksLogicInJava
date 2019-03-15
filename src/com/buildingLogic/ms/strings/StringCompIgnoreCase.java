package com.buildingLogic.ms.strings;

public class StringCompIgnoreCase {

  public int icStrcmp(String s1, String s2) {

    if (s1.length() < s2.length()) {
      s1 += " ";
    } else if (s1.length() > s2.length()) {
      s2 += " ";
    }
    
    int i;

    for (i = 0; i < s1.length() && i < s2.length(); ++i) {
      char c1 = s1.charAt(i);
      char c2 = s2.charAt(i);
      
      if (c1 == c2 || (c1 ^ 32) == c2) {
        continue;
      } 
      else {
        ++i;
        break;
      }
    }

    char c1 = s1.charAt(i - 1);
    char c2 = s2.charAt(i - 1);
    if ((c1 == c2 || (c1 ^ 32) == c2)) {
      return 0;
    }

    if ((c1 | 32) < (c2 | 32)) {
      return -1;
    }

    return 1;
  }

}
