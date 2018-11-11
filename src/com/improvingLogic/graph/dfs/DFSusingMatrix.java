/***
 * DFS using adjacency matrix
 */
package com.improvingLogic.graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.improvingLogic.graph.common.Node;

public class DFSusingMatrix {

	private static ArrayList<Node> nodes = new ArrayList<>();
	private static int counter = 0;

	private void dfsUsingRecursion(int[][] adjacencyMatrix, Node node) {
		node.setVisited(true);
		node.setEndTime(++counter);

		System.out.println("Element : " + node.getData() + " -> startTime: "
				+ node.getStartTime() + "  -> endTime: " + node.getEndTime());

		List<Node> neighNodes = getNeighboursFromAdjacencyMatrix(adjacencyMatrix, node);

		for (Node element : neighNodes) {
			if (null != element && !element.isVisited()) {
				element.setVisited(true);
				element.setStartTime(++counter);
				dfsUsingRecursion(adjacencyMatrix, element);
			}
		}
	}

	private void dfsUsingStack(int[][] adjacencyMatrix, Node node) {

		Stack<Node> dfsStack = new Stack<>();
		dfsStack.push(node);
		node.setVisited(true);
		node.setStartTime(++counter);

		while (!dfsStack.isEmpty()) {
			Node poppedElement = dfsStack.pop();
			poppedElement.setEndTime(++counter);
			System.out.println("Element : " + poppedElement.getData()
					+ " -> startTime: " + poppedElement.getStartTime()
					+ "  -> endTime: " + poppedElement.getEndTime());

			List<Node> neighbours = getNeighboursFromAdjacencyMatrix(
					adjacencyMatrix, poppedElement);
			for (Node element : neighbours) {
				if (null != element && !element.isVisited()) {
					dfsStack.push(element);
					element.setStartTime(++counter);
					element.setVisited(true);
				}
			}
		}

	}

	private List<Node> getNeighboursFromAdjacencyMatrix(
			int[][] adjacencyMatrix, Node node) {
		int nodeIndex = -1;
		List<Node> neighbours = new ArrayList<>();
		for (int i = 0; i < nodes.size(); ++i) {
			if (nodes.get(i).equals(node)) {
				nodeIndex = i;
				break;
			}
		}

		if (-1 != nodeIndex) {
			for (int i = 0; i < adjacencyMatrix[nodeIndex].length; ++i) {
				if (1 == adjacencyMatrix[nodeIndex][i]) {
					neighbours.add(nodes.get(i));
				}
			}
		}
		return neighbours;
	}

	public static void clearVisitedFlags() {
		for (int i = 0; i < nodes.size(); i++) {
			nodes.get(i).setVisited(false);
		}

		counter = 1;
	}

	public static void main(String[] args) {
		Node node40 = new Node(40);
		Node node10 = new Node(10);
		Node node20 = new Node(20);
		Node node30 = new Node(30);
		Node node60 = new Node(60);
		Node node50 = new Node(50);
		Node node70 = new Node(70);

		nodes.add(node40);
		nodes.add(node10);
		nodes.add(node20);
		nodes.add(node30);
		nodes.add(node60);
		nodes.add(node50);
		nodes.add(node70);
		int adjacencyMatrix[][] = { { 0, 1, 1, 0, 0, 0, 0 }, // Node 1: 40
				{ 0, 0, 0, 1, 0, 0, 0 }, // Node 2 :10
				{ 0, 1, 0, 1, 1, 1, 0 }, // Node 3: 20
				{ 0, 0, 0, 0, 1, 0, 0 }, // Node 4: 30
				{ 0, 0, 0, 0, 0, 0, 1 }, // Node 5: 60
				{ 0, 0, 0, 0, 0, 0, 1 }, // Node 6: 50
				{ 0, 0, 0, 0, 0, 0, 0 }, // Node 7: 70
		};

		DFSusingMatrix dfsFromMatrix = new DFSusingMatrix();

		System.out.println("The DFS traversal of the graph using stack ");
		dfsFromMatrix.dfsUsingStack(adjacencyMatrix, node40);

		System.out.println();

		clearVisitedFlags();

		System.out.println("The DFS traversal of the graph using recursion ");
		dfsFromMatrix.dfsUsingRecursion(adjacencyMatrix, node40);

	}
}
