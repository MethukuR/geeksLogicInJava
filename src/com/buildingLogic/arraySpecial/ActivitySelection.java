package com.buildingLogic.arraySpecial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Greedy is an algorithmic paradigm that builds up a solution piece by piece,
 * always choosing the next piece that offers the most obvious and immediate
 * benefit. Greedy algorithms are used for optimization problems. An
 * optimization problem can be solved using Greedy if the problem has the
 * following property: At every step, we can make a choice that looks best at
 * the moment, and we get the optimal solution of the complete problem. If a
 * Greedy Algorithm can solve a problem, then it generally becomes the best
 * method to solve that problem as the Greedy algorithms are in general more
 * efficient than other techniques like Dynamic Programming. But Greedy
 * algorithms cannot always be applied. For example, Fractional Knapsack problem
 * (See this) can be solved using Greedy, but 0-1 Knapsack cannot be solved
 * using Greedy.
 * 
 * Following are some standard algorithms that are Greedy algorithms. 
 1) Kruskal’s Minimum Spanning Tree (MST): In Kruskal’s algorithm, we create a
 * MST by picking edges one by one. The Greedy Choice is to pick the smallest
 * weight edge that doesn’t cause a cycle in the MST constructed so far. 
 
 2) Prim’s Minimum Spanning Tree: In Prim’s algorithm also, we create a MST by
 * picking edges one by one. We maintain two sets: a set of the vertices already
 * included in MST and the set of the vertices not yet included. The Greedy
 * Choice is to pick the smallest weight edge thatconnects the two sets. 
  
 3) Dijkstra’s Shortest Path: The Dijkstra’s algorithm
 * is very similar to Prim’s algorithm. The shortest path tree is built up, edge
 * by edge. We maintain two sets: a set of the vertices already included in the
 * tree and the set of the vertices not yet included. The Greedy Choice is to
 * pick the edge that connects the two sets and is on the smallest weight path
 * from source to the set that contains not yet included vertices. 

 4) Huffman Coding: Huffman Coding is a loss-less compression technique. It assigns
 * variable-length bit codes to different characters. The Greedy Choice is to
 * assign least bit length code to the most frequent character.
 * 
 * The greedy algorithms are sometimes also used to get an approximation for
 * Hard optimization problems. For example, Traveling Salesman Problem is a
 * NP-Hard problem. A Greedy choice for this problem is to pick the nearest
 * unvisited city from the current city at every step. This solutions don’t
 * always produce the best optimal solution but can be used to get an
 * approximately optimal solution.
 * 
 * Let us consider the Activity Selection problem as our first example of Greedy
 * algorithms. Following is the problem statement. You are given n activities
 * with their start and finish times. Select the maximum number of activities
 * that can be performed by a single person, assuming that a person can only
 * work on a single activity at a time. Example:
 * 
 * Example 1 : Consider the following 3 activities sorted by by finish time.
 * start[] = {10, 12, 20}; finish[] = {20, 25, 30}; A person can perform at most
 * two activities. The maximum set of activities that can be executed is {0, 2}
 * [ These are indexes in start[] and finish[] ]
 * 
 * Example 2 : Consider the following 6 activities sorted by by finish time.
 * start[] = {1, 3, 0, 5, 8, 5}; finish[] = {2, 4, 6, 7, 9, 9}; A person can
 * perform at most four activities. The maximum set of activities that can be
 * executed is {0, 1, 3, 4} [ These are indexes in start[] and finish[] ]
 * 
 * The greedy choice is to always pick the next activity whose finish time is
 * least among the remaining activities and the start time is more than or equal
 * to the finish time of previously selected activity. We can sort the
 * activities according to their finishing time so that we always consider the
 * next activity as minimum finishing time activity.
 * 
 * 
 * 
 * 1) Sort the activities according to their finishing time 
 * 2) Select the first
 * activity from the sorted array and print it. 
 * 3) Do following for remaining
 * activities in the sorted array. …….
 * 	a) If the start time of this activity is
 * 		greater than or equal to the finish time of previously selected activity then
 * 		select this activity and print it.
 * 
 * How does Greedy Choice work for Activities sorted according to finish time?
 * Let the given set of activities be S = {1, 2, 3, ..n} and activities be
 * sorted by finish time. The greedy choice is to always pick activity 1. How
 * come the activity 1 always provides one of the optimal solutions. We can
 * prove it by showing that if there is another solution B with the first
 * activity other than 1, then there is also a solution A of the same size with
 * activity 1 as the first activity. Let the first activity selected by B be k,
 * then there always exist A = {B – {k}} U {1}.(Note that the activities in B
 * are independent and k has smallest finishing time among all. Since k is not
 * 1, finish(k) >= finish(1)).
 * 
 * @author Ranger Raju :P
 *
 */

class Activity {
	private String name;
	private int startTime;
	private int finishTime;

	public Activity(String name, int startTime, int finishTime) {
		super();
		this.name = name;
		this.startTime = startTime;
		this.finishTime = finishTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}

	/* Comparator for sorting the list by finish time */
	public static Comparator<Activity> activityComparator = new Comparator<Activity>() {

		public int compare(Activity a1, Activity a2) {

			int f1 = a1.getFinishTime();
			int f2 = a2.getFinishTime();

			/* For ascending order */
			return f1 - f2;

			/* For descending order */
			// f2-f1;
		}
	};
}
/*{5, 9}, {1, 2}, {3, 4}, {0, 6},
{5, 7}, {8, 9}*/
public class ActivitySelection {

	public static void main(String[] args) {
		ArrayList<Activity> activities = new ArrayList<Activity>();
		activities.add(new Activity("a1", 5, 9));
		activities.add(new Activity("a2", 1, 2));
		activities.add(new Activity("a3", 3, 4));
		activities.add(new Activity("a4", 0, 6));
		activities.add(new Activity("a5", 5, 7));
		activities.add(new Activity("a6", 8, 9));
		
		System.out.println("Activities before sorting: ");
		for(Activity activity : activities){
			System.out.println("Name :"+ activity.getName() + " startTime : "+activity.getStartTime()+ " finishTime : "+activity.getFinishTime());
		}
		
		// Sort activities according to finish time
		Collections.sort(activities, Activity.activityComparator);
		System.out.println("Activities after sorting: ");
		
		for(Activity activity : activities){
			System.out.println("Name :"+ activity.getName() + " startTime : "+activity.getStartTime()+ " finishTime : "+activity.getFinishTime());
		}
		
	    int i = 0;
	    for (Iterator<Activity> it = activities.iterator(); it.hasNext(); i++) {
	        Activity activity = it.next();
		    if(i == 0){
				System.out.println("Name :"+ activity.getName() + " startTime : "+activity.getStartTime()+ " finishTime : "+activity.getFinishTime());
		    }else{
		    	
		    }
	        System.out.println(i + ": ");
	    }
		

	}

}
