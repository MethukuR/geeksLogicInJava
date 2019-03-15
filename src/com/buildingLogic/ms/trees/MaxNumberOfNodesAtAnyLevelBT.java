/**
 * Find the level in a binary tree which has maximum number of nodes. The root is at level 0.

Examples:

Input : 
       2             
    /     \          
   1        3            
 /   \       \       
4     6        8     
     /                
    5

Output : 2

        2             
     /     \          
    1        3            
  /   \       \       
 4    6        8 [Level with maximum nodes = 3]
     /                
    5
 

We know that in level order traversal of binary tree with queue, at any time our queue contains all 
elements of a particular level. So find level with maximum number of nodes in queue.
 */
package com.buildingLogic.ms.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxNumberOfNodesAtAnyLevelBT {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(6);
    root.setLeft(new TreeNode(2));
    root.setRight(new TreeNode(10));
    root.getLeft().setLeft(new TreeNode(1));
    root.getLeft().setRight(new TreeNode(3));
    root.getRight().setRight(new TreeNode(12));
    root.getRight().setLeft(new TreeNode(7));
    
    System.out.println(findLevelWithMaxNodes(root));
  }
  
  public static int findLevelWithMaxNodes(TreeNode root) {
    if(root == null) {
      return -1;
    }
    
    int maxLevel = 0;
    int curLevel = 0;
    int maxNodes = 1;
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.add(root);
    
    while(true) {
      int nodesCount = q.size();
      
      if(nodesCount == 0) {
        break;
      }
      
      if(nodesCount > maxNodes) {
        maxNodes = nodesCount;
        maxLevel = curLevel;
      }
      
      
      while(nodesCount > 0) {
        TreeNode curNode = q.poll();
        if(curNode.getLeft() != null) {
          q.add(curNode.getLeft());
        }
        
        if(curNode.getRight() != null) {
          q.add(curNode.getRight());
        }
        
        --nodesCount;
      }
      ++curLevel;

    }
    
    return maxLevel;
  }

}
