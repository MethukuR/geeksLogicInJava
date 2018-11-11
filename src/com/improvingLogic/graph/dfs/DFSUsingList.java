/***
 * Depth First Search using Adjacency list
 */
package com.improvingLogic.graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.improvingLogic.graph.common.Node;

public class DFSUsingList {
	
	private static int counter = 0;

	private List<Node> dfsUsingStack(Node node) {
		
		List<Node> nodesAfterDfs = new ArrayList<>();
		Stack<Node> dfsStack = new Stack<>();
		dfsStack.push(node);
		node.setVisited(true);
		node.setStartTime(++counter);

		while (!dfsStack.isEmpty()) {
			Node element = dfsStack.pop();
			element.setEndTime(++counter);
			System.out.println("Element : "+element.getData() + " -> startTime: "+element.getStartTime() + "  -> endTime: "+element.getEndTime());
			nodesAfterDfs.add(element);
			
			List<Node> neighbours = element.getNeighbours();
			for (Node neighbour : neighbours) {
				if (null != neighbour && !neighbour.isVisited()) {
					dfsStack.push(neighbour);
					neighbour.setVisited(true);
					neighbour.setStartTime(++counter);
				}
			}
		}
		
		return nodesAfterDfs;
	}
	
	private void dfsRecursion(Node node) {
		node.setVisited(true);
		node.setEndTime(++counter);
		System.out.println("Element : "+node.getData() + " -> startTime: "+node.getStartTime() + "  -> endTime: "+node.getEndTime());
		
		List<Node> neighbours = node.getNeighbours();
		for (Node neighbour : neighbours) {
			if(null != neighbour && !neighbour.isVisited()){
				neighbour.setStartTime(++counter);
				dfsRecursion(neighbour);
			}
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

		DFSUsingList dFSUsingList = new DFSUsingList();

		System.out.println("The DFS traversal of the graph using stack ");
		dFSUsingList.dfsUsingStack(node40);

		System.out.println();

		// Resetting the visited flag for nodes
		node40.setVisited(false);
		node10.setVisited(false);
		node20.setVisited(false);
		node30.setVisited(false);
		node60.setVisited(false);
		node50.setVisited(false);
		node70.setVisited(false);
		counter = 1;

		System.out.println("The DFS traversal of the graph using recursion ");
		dFSUsingList.dfsRecursion(node40);
	}

}
