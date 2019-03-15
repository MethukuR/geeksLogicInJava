/**
 * Longest Even Length Substring such that Sum of First and Second Half is same
Given a string ‘str’ of digits, find the length of the longest substring of ‘str’, such that the 
length of the substring is 2k digits and sum of left k digits is equal to the sum of right k digits.
Examples :

Input: str = "123123"
Output: 6
The complete string is of even length and sum of first and second
half digits is same

Input: str = "1538023"
Output: 4
The longest substring with same first and second half sum is "5380"

 */
package com.buildingLogic.ms.strings;

public class LongestEvenLenSubstrWithConstraint {

  public static void main(String[] args) {
    System.out.println(findLength("1231237"));
  }
  
  private static int findLength(String input) {
    if(input.length() == 0 || input.length() == 1){
      return 0;
    }
    
    int inpLen = input.length();
    int maxLen = 0;
    
    for (int i = 0; i <= inpLen-2; i++) {
      int lIndex = i;
      int rIndex = i+1;
      
      int lSum = 0;
      int rSum = 0;
      
      while(lIndex >=0 && rIndex < inpLen) {
        lSum += input.charAt(lIndex) - '0';
        rSum += input.charAt(rIndex) - '0';
        
        if(lSum == rSum) {
          maxLen = Math.max(maxLen, rIndex-lIndex+1);
        }
        
        --lIndex;
        ++rIndex;
      }
    }
    
    return maxLen;
  }

}
