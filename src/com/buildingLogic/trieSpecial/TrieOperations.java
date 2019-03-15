package com.buildingLogic.trieSpecial;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
  Map<Character, TrieNode> children;
  boolean endOfWord;
  
  public TrieNode(){
    children = new HashMap<>();
    endOfWord = false;
  }
  
}

public class TrieOperations {
  private final TrieNode root;
  
  public TrieOperations() {
    root = new TrieNode();
  }
  
  public static void main(String[] args) {
    TrieOperations trieOp = new TrieOperations();
    trieOp.insertWord("abcd");
    
    trieOp.search("abcd");
    
    trieOp.deleteWord("abcd");
  }

  private boolean deleteWord(String word) {
     
    return delete(root, word, 0);
  }

  private static boolean delete(TrieNode cur, String word, int index) {
    if(index == word.length()) {
      if(!cur.endOfWord) {
        return false;
      }
      
      cur.endOfWord = false;
      
      return cur.children.size() == 0;
      
    }
    
    TrieNode node = cur.children.get(word.charAt(index)); 
    if( null == node) {
      return false;
    }
    
    boolean shouldDelete = delete(node, word, index+1);
    if(shouldDelete) {
      node.children.remove(word.charAt(index));
      
      return node.children.size() == 0;
    }
    return false;
  }

  private boolean search(String word) {
    TrieNode cur = root;
    for (int i = 0; i < word.length(); i++) {
      char curChar = word.charAt(i);
      TrieNode node = cur.children.get(curChar);
      
      if( null == node) {
        return false;
      }
      cur = node;
    }
    return cur.endOfWord;
  }

  private void insertWord(String word) {
    TrieNode cur = root;
    for (int i = 0; i < word.length(); i++) {
      char curChar = word.charAt(i);
      TrieNode node = cur.children.get(curChar);
      
      if( null == node) {
        node = new TrieNode();
        cur.children.put(curChar, node);
      }
      cur = node;
    }
    
    cur.endOfWord = true;
  }

}
