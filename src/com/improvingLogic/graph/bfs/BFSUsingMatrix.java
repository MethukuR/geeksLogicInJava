/***
 * BFS using adjacency matrix
 */
package com.improvingLogic.graph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.improvingLogic.graph.common.Node;

public class BFSUsingMatrix {

	private static ArrayList<Node> nodes = new ArrayList<>();
	private static int counter = 0;

	private void bfsUsingStack(int[][] adjacencyMatrix, Node node) {

		Queue<Node> bfsStack = new LinkedList<>();
		bfsStack.add(node);
		node.setVisited(true);
		node.setStartTime(++counter);

		while (!bfsStack.isEmpty()) {
			Node removedElement = bfsStack.remove();
			removedElement.setEndTime(++counter);
			System.out.println("Element : " + removedElement.getData()
					+ " -> startTime: " + removedElement.getStartTime()
					+ "  -> endTime: " + removedElement.getEndTime());

			List<Node> neighbours = getNeighboursFromAdjacencyMatrix(
					adjacencyMatrix, removedElement);
			for (Node element : neighbours) {
				if (null != element && !element.isVisited()) {
					bfsStack.add(element);
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

		BFSUsingMatrix dfsFromMatrix = new BFSUsingMatrix();

		System.out.println("The DFS traversal of the graph using stack ");
		dfsFromMatrix.bfsUsingStack(adjacencyMatrix, node40);
	}
}

