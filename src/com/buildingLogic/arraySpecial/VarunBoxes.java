package com.buildingLogic.arraySpecial;
/**
 * Varun is playing a very interesting game. He has some N different type of boxes. All boxes may have 
 * different number of balls (Si. 52.   Sn). 
   Varun chose two random numbers F and K. K should be less than N. The game is that Varun wants to any K 
   boxes out of N boxes such that total number of balls in these K selected boxes should be some multiple 
   of F. 
   At the same time Varun wants that sum of the balls of the selected boxes should be minimum possible. 

   Input Format: 
   ------------
   Your function will have three arguments -1) A array S .(S1, S2., Sn) of size N 
   corresponding to the number of balls in N boxes(0<=hIc=1000) 2) F- value (as explained above) 3) 
   K- value (as explained above) 

   Output Format: 
   -------------
   Minimum possible total number of balls such that the condition(s) explained in the problem statement is 
   satisfied. Output should be -1 if it is not possible or Invalid input. 
   
   Sample Test Case: 
   ----------------
   Sample Input: 
   -------------
   5 
   1 
   2 
   3 
   4 
   5 
   5 
   3 
   
   Sample Output: 
   -------------
   10 
   
 * @author Ranger Raju :)
 */
import java.util.Scanner;

public class VarunBoxes {
	static int minBalls=Integer.MAX_VALUE;
	
	public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);

		int n=scn.nextInt();

		int[] inputArr= new int[n];

		for (int i = 0; i < n; ++i) {
			inputArr[i]=scn.nextInt();
		}

		int f= scn.nextInt();

		int k= scn .nextInt();

		int ballsCount=ball_count(inputArr, f, k);
		System.out.println(ballsCount);

		scn.close();
	} 
	
	private static void combinationUtil(int arr[], int n, int r,int f, int index,int data[], int i){
		if (index == r){
			int sum =0;
			for (int j=0; j<r; j++){
				sum+=data[j];
			}
			if((sum%f == 0) && sum < minBalls){
				minBalls=sum;
			}
			return;
		}

		if (i >= n)
			return;

		data[index] = arr[i];
		combinationUtil(arr, n, r,f, index+1, data, i+1);

		combinationUtil(arr, n, r,f, index, data, i+1);
	}

	public static int ball_count(int arr[], int f, int k){
		int data[]=new int[f];
		int n=arr.length;
		combinationUtil(arr, n, k,f, 0, data, 0);
		if(minBalls == Integer.MAX_VALUE){
			minBalls=-1;
		}
		return minBalls;
	}

	
}
