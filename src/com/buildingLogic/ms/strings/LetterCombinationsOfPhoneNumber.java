package com.buildingLogic.ms.strings;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

  public static void main(String[] args) {
    System.out.println(findLetterCombinations("789"));
  }

  public static List<String> findLetterCombinations(String digits) {
    List<String> results = new ArrayList<>();

    if (digits == null || digits.length() == 0) {
      return results;
    }

    String[] phoneMapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    findLetterCombinationsUtil("", 0, phoneMapping, results, digits);

    return results;
  }

  private static void findLetterCombinationsUtil(String current, int index, String[] phoneMapping,
      List<String> results, String digits) {

    if (index == digits.length()) {
      results.add(current);
      return;
    }

    String letters = phoneMapping[digits.charAt(index) - '0'];

    for (int i = 0; i < letters.length(); i++) {
      findLetterCombinationsUtil(current + phoneMapping[digits.charAt(index) - '0'].charAt(i),
          index + 1, phoneMapping, results, digits);
    }
  }

}
