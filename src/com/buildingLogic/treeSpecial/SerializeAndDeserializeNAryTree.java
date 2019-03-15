package com.buildingLogic.treeSpecial;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserializeNAryTree {
  public static void main(String[] args) throws UnsupportedEncodingException {
    Node root = new Node("5");  
    Node ch1 = new Node("8");  
    Node ch2 = new Node("9");  
    Node ch3 = new Node("11");  
    root.addChild(ch1);  
    root.addChild(ch2);  
    root.addChild(ch3);  
    Node ch4 = new Node("13");  
    Node ch5 = new Node("17");  
    Node ch6 = new Node("18");  
    Node ch7 = new Node("20");  
    Node ch8 = new Node("22");  
    ch1.addChild(ch4);  
    ch1.addChild(ch5);  
    ch4.addChild(ch6);  
    ch6.addChild(ch7);  
    ch7.addChild(ch8);  
    Node ch9 = new Node("23");  
    Node ch10 = new Node("25");  
    Node ch11 = new Node("27");  
    Node ch12 = new Node("28");  
    Node ch13 = new Node("32");  
    Node ch14 = new Node("31");  
    Node ch15 = new Node("33");  
    Node ch16 = new Node("34");  
    Node ch17 = new Node("29");  
    ch5.addChild(ch9);  
    ch3.addChild(ch10);  
    ch3.addChild(ch11);  
    ch10.addChild(ch12);  
    ch10.addChild(ch14);  
    ch12.addChild(ch13);  
    ch14.addChild(ch15);  
    ch14.addChild(ch16);  
    ch14.addChild(ch17);  
    String packed = Node.serialize(root);  
    System.out.println(packed);  
    Node compareTo = Node.deserialize(packed);  
    System.out.println(root.equals(compareTo));

  }
}

class Node {  
  String key;  
  List<Node> childs = null;  
  public Node(String key) {  
       this.key = key;  
       this.childs = new ArrayList<Node>();  
  }  
  public void addChild(Node child) {  
       this.childs.add(child);  
  }  
  public static String serialize(Node root) {
    StringBuilder sb = new StringBuilder();
    serializeHelper(root, sb);
    return sb.toString();
  }  
  private static void serializeHelper(Node root, StringBuilder sb) {
    if(root == null) {
      sb.append("null").append(",");
    }else {
      sb.append(root.key).append(",");
      List<Node> children = root.childs;
      int size = children.size();
      sb.append(size).append(",");
      
      for (int i = 0; i < size; i++) {
        serializeHelper(children.get(i), sb);
      }
    }
  }
  public static Node deserialize(String serializedTree)  {
    Queue<String> q = new LinkedList<>();
    q.addAll(Arrays.asList(serializedTree.split(",")));
    return deserialiseHelper(q);
  }
  
  
  private static Node deserialiseHelper(Queue<String> q) {
    String val = q.poll();
    if(val.equals("null")) {
      return null;
    }else {
      int size = Integer.parseInt(q.poll());
      Node root = new Node(val);
      root.childs = new ArrayList<>(size);
      
      for (int i = 0; i < size; i++) {
        root.childs.add(deserialiseHelper(q));
      }
      
      return root;
    }
  }
  public boolean equals(Node compareTo) {  
       if (null == compareTo) {  
            return false;  
       }  
       if (this.key.equals(compareTo.key)) {  
            boolean result = true;  
            for (int i = 0; i < this.childs.size(); i++) {  
                 result = result  
                           && this.childs.get(i).equals(compareTo.childs.get(i));  
            }  
            return result;  
       } else {  
            return false;  
       }  
  }  
}  

