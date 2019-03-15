package com.buildingLogic.ms.strings;

import java.util.HashSet;
import java.util.Set;

public class PermutationsOfStringOfGivenLength {

  public static void main(String[] args) {
    //System.out.println(findPermutations("abc"));
  }
  
  public Set<String> findPermutations(String s){
    if(s == null) {
      return null;
    }
    
    Set<String> results = new HashSet<>();
    if(s.length() == 0 || s.length() == 1) {
      results.add(s);
    }
    
    findPermutations("", s, results);
    return results;
  }
  
  private static void findPermutations(String prefix, String suffix, Set<String> results){
    if(suffix.length() == 0) {
      results.add(prefix);
    }else {
      for (int i = 0; i < suffix.length(); i++) {
        findPermutations(prefix+suffix.charAt(i), 
            suffix.substring(0, i)+suffix.substring(i+1), results);
      }
    }
  }

}
