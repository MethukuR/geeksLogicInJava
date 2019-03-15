/***
 * Topological Sorting is ordering of vertices or nodes such if there is an edge between (u,v) then
 * u should come before v in topological sorting. Topological sort is possible only for Directed
 * Acyclic Graph(DAG). If there is a cycle in graph, then there won�t be any possibility for
 * Topological Sort.
 * 
 * This algorithm is a variant of Depth-first search. In depth first search, we first print the
 * vertex and then go to its neighbours but in case of topological sort, we don�t print vertex
 * immediately instead we push it to the Stack.
 * 
 * In topological sorting, we will have a temporary stack. We are not going to print the vertex
 * immediately, we first recursively call topological sorting for all its neighbour vertices, then
 * push it to a stack. We will print stack once we are done with recursive topolgical sorting.
 * 
 * Why it works? 
 * It works because when you push any node to stack, you have already pushed its
 * neighbours (and their neighbours and so on),so node which does not have any dependency will be on
 * the top of stack.
 */
package com.improvingLogic.graph.topologicalSort;

import java.util.List;
import java.util.Stack;
import com.improvingLogic.graph.common.Node;

public class TopologicalSort {

  private static int counter = 0;
  private static Stack<Node> nodesAfterTS = new Stack<>();

  private void topologicalSortUsingStack(Node node) {

    Stack<Node> dfsStack = new Stack<>();
    dfsStack.push(node);
    node.setVisited(true);
    node.setStartTime(++counter);

    while (!dfsStack.isEmpty()) {
      Node element = dfsStack.pop();
      List<Node> neighbours = element.getNeighbours();

      for (Node neighbour : neighbours) {
        if (null != neighbour && !neighbour.isVisited()) {
          dfsStack.push(neighbour);
          neighbour.setVisited(true);
          neighbour.setStartTime(++counter);
        }
      }
      element.setEndTime(++counter);
      nodesAfterTS.push(element);
    }
  }

  public static void main(String arg[]) {

    Node node40 = new Node(40);
    Node node10 = new Node(10);
    Node node20 = new Node(20);
    Node node30 = new Node(30);
    Node node60 = new Node(60);
    Node node50 = new Node(50);
    Node node70 = new Node(70);

    node40.addneighbours(node10);
    node40.addneighbours(node20);
    node10.addneighbours(node30);
    node20.addneighbours(node10);
    node20.addneighbours(node30);
    node20.addneighbours(node60);
    node20.addneighbours(node50);
    node30.addneighbours(node60);
    node60.addneighbours(node70);
    node50.addneighbours(node70);

    TopologicalSort ts = new TopologicalSort();

    System.out.println("The topologicalSorting of the graph using stack ");
    ts.topologicalSortUsingStack(node40);

    while (!nodesAfterTS.isEmpty()) {
      Node node = nodesAfterTS.pop();
      System.out.println("Element : " + node.getData() + " -> startTime: " + node.getStartTime()
          + "  -> endTime: " + node.getEndTime());
    }

  }

}
