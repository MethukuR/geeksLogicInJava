/**
 * Description 中文 English Given a string source and a string target, find the minimum window in
 * source which will contain all the characters in target.
 * 
 * If there is no such window in source that covers all characters in target, return the emtpy
 * string "". If there are multiple such windows, you are guaranteed that there will always be only
 * one unique minimum window in source. The target string may contain duplicate characters, the
 * minimum window should cover all characters including the duplicate characters in target.
 * 
 * Clarification: Should the characters in minimum window has the same order in target? Not
 * necessary.
 * 
 * Examples:
 * 
 * Example 1:
 * 
 * Input: "" "" Output: "" Example 2:
 * 
 * Input: "ADOBECODEBANC" "ABC" Output: "BANC"
 * 
 * Challenge Can you do it in time complexity O(n) ?
 * 
 * 
 */
package com.buildingLogic.ms.strings;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubString {

  public static void main(String[] args) {
    String source = "abc";
    String target = "ac";
    System.out.println(findMinWindowSubString(source, target));
  }

  private static String findMinWindowSubString(String source, String target) {
    if (source == null || target == null || source.length() < target.length()) {
      return "";
    }

    Map<Character, Integer> need = new HashMap<>();
    int targetLen = target.length();
    for (int i = 0; i < targetLen; ++i) {
      char curChar = target.charAt(i);
      if (need.containsKey(curChar)) {
        need.put(curChar, need.get(curChar) + 1);
      } else {
        need.put(curChar, 1);
      }
    }
    int missing = targetLen;
    int i = 0, j = 0, l = 0, r = 0;
    int sourceLen = source.length();
    int minLength = sourceLen;
    String targetWindow = "";
    while (r < sourceLen) {
      char curChar = source.charAt(r);
      if (need.get(curChar) != null) {
        if (need.get(curChar) > 0) {
          --missing;
        } 
        need.put(curChar, need.get(curChar) - 1);
      }


      while (missing == 0) {
        i = l;
        j = r;
        if (minLength > j - i + 1) {
          minLength = j - i + 1;
          targetWindow = source.substring(i, j + 1);
        }

        if (!need.containsKey(source.charAt(l))) {
          ++l;
        } else {
          if (need.get(source.charAt(l)) >= 0) {
            ++missing;
          }
          need.put(source.charAt(l), need.get(source.charAt(l)) + 1);
          ++l;
        }
      }
      ++r;
    }
    return targetWindow;
  }

}
