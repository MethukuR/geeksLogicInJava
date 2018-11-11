package com.improvingLogic.graph.common;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private int data;
	private boolean visited;
	private List<Node> neighbours;
	private int startTime;
	private int endTime;

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	@Override
	public String toString() {
		return data+"";
	}

	public Node(int data) {
		this.data = data;
		this.neighbours = new ArrayList<>();

	}

	public void addneighbours(Node neighbourNode) {
		this.neighbours.add(neighbourNode);
	}

	public List<Node> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(List<Node> neighbours) {
		this.neighbours = neighbours;
	}
}
