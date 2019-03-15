package com.buildingLogic.ms.strings;

import java.util.HashSet;
import java.util.Set;

public class PermutationsOfString {
    
  public Set<String> permutationsFinder(String str){
      
      if(str == null) {
        return null;
      }
      
      Set<String> permutations = new HashSet<>();
      
      if(str.length() == 0 || str.length() == 1) {
        permutations.add(str);
        return permutations;
      }
      
      char firstChar = str.charAt(0);
      String remaining = str.substring(1);
      
      Set<String> words = permutationsFinder(remaining);
      
      for (String word : words) {
        int wordLength = word.length();
        for (int i = 0; i <= wordLength; i++) {
          permutations.add(charInsert(word, firstChar, i));
        }
      }
      
      return permutations;
    }

    private static String charInsert(String word, char firstChar, int i) {
      String start = word.substring(0, i);
      String last = word.substring(i);
      
      return start+firstChar+last;
    }
    
    public static void main(String[] args) {
      PermutationsOfString ofString = new PermutationsOfString();
      Set<String> s = ofString.permutationsFinder("abc");
      
      for (String string : s) {
        System.out.println(string);
      }
    }
}
