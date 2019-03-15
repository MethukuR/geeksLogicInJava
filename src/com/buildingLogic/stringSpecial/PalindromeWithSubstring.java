/**
 * Given two strings s1 and s2, we have to convert s1 into palindrome such that s1 contain s2 as a
 * substring. in a minimum number of operation. wherein a single operation we can replace any word
 * of s1 with any character. 
 * constraint : 
 * |s1| <= 1000 
 * |s2| <= |s1| 
 * 
 * ex: 
 * s1 = "abaa" , 
 * s2 = "bb"
 * output = 1 
 * 
 * ex:
 * s1 = aaaaa 
 * s2= bbb 
 * output: 3
 */
package com.buildingLogic.stringSpecial;

public class PalindromeWithSubstring {

  public static void main(String[] args) {
     //System.out.println(countMinOperations("abcd", "aaa"));
     System.out.println(countMinOperationsTwo("abcd", "aaa"));

  }

  private static int countMinOperationsTwo(String s1, String s2) {
    
    if(s1.equals(s2)) {
      return 0;
    }
    
    int sOneLen = s1.length();
    int sTwoLen = s2.length();
    
    if(sOneLen == 0) {
      return -1;
    }
    
    if(sTwoLen == 0) {
      return 0;
    }
    
    if(s1.indexOf(s2) != -1) {
      return operationsToMakePalindrome(s1);
    }
      
    String pS2 = null;
    
    if(operationsToMakePalindrome(s2) > 0) {
      pS2 = makeS2Palindrome(s2);
    }else {
      pS2 = s2;
    }
   
     if((sOneLen - pS2.length()) < 0 || (sOneLen - pS2.length())%2 != 0) {
       return -1;
     }
     
     int operations =  operationsForReplacement(s1, pS2);
     return operations;
    
  }

  private static int operationsForReplacement(String s1, String s2) {
    int s2Len = s2.length();
    int s1Len = s1.length();
    
    if(s1Len == s2Len) {
      return findCharDiffCount(s1, s2, s1Len);
    }
    int temp = (s1Len - s2Len)/2;
    int operations = 0;
    for (int i = 0; i < temp; i++) {
      if(s1.charAt(i) != s1.charAt(s1Len-1-i)) {
        ++operations;
      }
    }
    
    operations += findCharDiffCount(s1.substring(temp, temp+s2Len), s2, s2Len);
    
    return operations;
  }

  private static String makeS2Palindrome(String s) {
    
    int len = s.length();
    int i, j;
    
    
      i = len-1;
      j = len-2;
    
    
    
    while( i >= 0 && j >= 0) {
      if(s.charAt(i) != s.charAt(j)) {
        break;
      }
      --j;
    }
    
    if(j < 0) {
      return s;
    }
    
    s += reverse(s.substring(0, j+1));
    return s;
  }

  private static String reverse(String s) {
    int i =0;
    int j = s.length() -1;
    char[] charArr = s.toCharArray();
    
    while(i < j) {
      char temp = charArr[i];
      charArr[i] = charArr[j];
      charArr[j] = temp;
      ++i;
      --j;
    }
    
    return new String(charArr);
  }

  private static int countMinOperations(String sOne, String sTwo) {
   
    if(sOne.equals(sTwo)) {
     return 0;
   }
   
   int sOneLen = sOne.length();
   int sTwoLen = sTwo.length();
   
   if(sOneLen == 0) {
     return -1;
   }
   
   if(sTwoLen == 0) {
     return 0;
   }
   
   int minOperations = Integer.MAX_VALUE;

   if(sOne.indexOf(sTwo) != -1) {
     return operationsToMakePalindrome(sOne);
   }else {
     for (int i = 0; i < sOneLen-sTwoLen + 1; i++) {
      String first = sOne.substring(0, i);
      String last = sOne.substring(i+sTwoLen);
      String removed = sOne.substring(i, i+sTwoLen);
      
      int charDiff = findCharDiffCount(sTwo, removed, sTwoLen) ;
      if(charDiff > sOneLen/2 && operationsToMakePalindrome(sTwo) != 0) {
        minOperations =  -1;
        break;
      }
      int operations = operationsToMakePalindrome(first+sTwo+last);
      
      int min = charDiff + operations;
      minOperations = (minOperations > min) ? min : minOperations;
      
      System.out.println("index: "+i + " first: "+first+ " removed: "+ removed + " last: "+last);
    }
   }
   
   return minOperations;
  }
  
  private static int findCharDiffCount(String sOne, String sTwo, int n) {
    int count = 0;
    for (int i = 0; i < n; i++) {
      if(sOne.charAt(i) != sTwo.charAt(i)) {
        ++count;
      }
    }
    return count;
  }

  private static int operationsToMakePalindrome(String s) {
    int count = 0;
    int i = 0;
    int j = s.length() - 1;
    
    while(i < j) {
      if(s.charAt(i) != s.charAt(j)) {
        ++count;
      }
      
      ++i;
      --j;
    }
     
    return count;
  }

}
