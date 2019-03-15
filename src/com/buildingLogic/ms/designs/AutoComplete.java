package com.buildingLogic.ms.designs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutoComplete {
  private class Node {
    String prefix;
    Map<Character, Node> children;
    boolean isWord;

    public Node(String prefix) {
      super();
      this.prefix = prefix;
      this.children = new HashMap<>();
    }

    public String getPrefix() {
      return prefix;
    }

    public Map<Character, Node> getChildren() {
      return children;
    }

    public void setWord(boolean isWord) {
      this.isWord = isWord;
    }
  }

  private Node root;

  public AutoComplete(String[] words) {
    root = new Node("");
    for (String word : words) {
      insertWord(root, word);
    }
  }

  private void insertWord(Node root, String word) {
    Node cur = root;
    int wordLen = word.length();

    for (int i = 0; i < wordLen; i++) {
      char curChar = word.charAt(i);
      Node node = cur.getChildren().get(curChar);

      if (node == null) {
        String prefix = word.substring(0, i + 1);
        node = new Node(prefix);
        cur.getChildren().put(curChar, node);
      }
      cur = node;
    }
    cur.setWord(true);
  }

  public List<String> getAllWordsForPrefix(String prefix) {
    List<String> results = new ArrayList<>();
    if (root == null) {
      return results;
    }

    int prefixLen = prefix.length();
    Node cur = root;
    for (int i = 0; i < prefixLen; i++) {
      char curChar = prefix.charAt(i);
      Node node = cur.getChildren().get(curChar);
      if (node == null) {
        return results;
      }
      cur = node;
    }

    findAllChildWords(cur, results);

    return results;
  }

  private void findAllChildWords(Node cur, List<String> results) {
    if (cur.isWord) {
      results.add(cur.getPrefix());
    }

    for (Character c : cur.getChildren().keySet()) {
      findAllChildWords(cur.getChildren().get(c), results);
    }
  }

  public static void main(String[] args) {
      AutoComplete aComp = new AutoComplete(new String[]{"abc", "acd", "bcd", "def", "a", "aba"});
      System.out.println(aComp.getAllWordsForPrefix("b"));
  }

}
