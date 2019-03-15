/***
 * Depth First Search using Adjacency list
 */

package com.improvingLogic.graph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.improvingLogic.graph.common.Node;

public class BFSUsingList {
	
	private static int counter = 0;

	private List<Node> bfsUsingQueue(Node node) {
		
		List<Node> nodesAfterBfs = new ArrayList<>();
		Queue<Node> bfsQueue = new LinkedList<>();
		bfsQueue.offer(node);
		node.setVisited(true);
		node.setStartTime(++counter);

		while (!bfsQueue.isEmpty()) {
			Node element = bfsQueue.poll();
			element.setEndTime(++counter);
			System.out.println("Element : "+element.getData() + " -> startTime: "+element.getStartTime() + "  -> endTime: "+element.getEndTime());
			nodesAfterBfs.add(element);
			
			List<Node> neighbours = element.getNeighbours();
			for (Node neighbour : neighbours) {
				if (null != neighbour && !neighbour.isVisited()) {
					bfsQueue.offer(neighbour);
					neighbour.setVisited(true);
					neighbour.setStartTime(++counter);
				}
			}
		}
		
		return nodesAfterBfs;
	}
	
	public static List<List<Integer>> bfsTree(Node root){
		if(root == null) {
			return null;
		}
		
		List<List<Integer>> nodesAfterBfs = new ArrayList<List<Integer>>();
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			int size = q.size();
			Node cur = q.poll();
			
			List<Integer> curRow = new ArrayList<>();
			while(size > 0) {
				--size;
				curRow.add(cur.getData());
				if(cur.left != null) {
					q.offer(cur.left);
				}
				
				if(cur.right != null) {
					q.offer(cur.right);
				}
			}
			
			nodesAfterBfs.add(curRow);
			
		}
		return nodesAfterBfs;
		
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

		BFSUsingList dFSUsingList = new BFSUsingList();

		System.out.println("The DFS traversal of the graph using stack ");
		dFSUsingList.bfsUsingQueue(node40);
	}

}

