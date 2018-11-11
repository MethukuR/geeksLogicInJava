package com.improvingLogic;

import java.util.Arrays;

/**
 * BRIDGE CONSTRUCTION COMPANY:
 * ----------------------------
	A famous bridge construction company has got a project of making a bridge over a long 
	river. The engineers of the company have decided to make it using Concrete and Pipes. 
	Company has some remaining material from last project and has decided to utilize them 
	in this project. Remaining material includes some pipes which are of variable length. 
	To utilize these pipes company has to connect them, which is going to cost them. The 
	cost for connecting the pipes depends upon their length. Let s say they want to 
	connect two pipes of length 4m and 10m, then cost will be $14 (i.e. 4 + 10 = $14).
	
	Suppose company has 4 remaining pipes from last project and decides to connect them 
	for this project. The length of pipes are 4m, 2m, 3m and 6m. 
	
	                                                
	You have to make a program to help the construction company in connecting the pipes 
	such that it results in minimum cost.
	
	For given case you have 4 pipes with length 4m, 2m, 3m and 6m. As the cost for 
	connecting two pipes depends on the length so the minimum cost method can be
	
	First connect 2m pipe and 3m pipe, which will going to cost $5 
	Then connect 5m (made using 2m and 3m pipe) and 4m pipe, which will cost $9 
	Then finally connect 6m and 9m pipe, which will cost $15 
	
	So the total cost to the company will be $29, which is the minimum possible cost using 
	the lengths of joined pipes as {5,9,15}. If company would have taken other method like 
	connecting the 4m and 2m pipe first, then 6m and 3m, then 9m and 6m pipe then cost 
	
	would have been $30 and lengths of joined pipes will be {6,9,15}. 
	
	If the number of remaining pipes to be connected is 1, then cost would be $0 and 
	lengths of joined pipes will be {0}.
	
	Make a program to find the minimum possible cost for connecting two remaining pipes 
	of last construction and return the length of all the pipes joined that is sorted in 
	ascending order. 
	
	Input Format:
	You will be given a function which contains an array of N-integers as argument, which 
	depicts remaining pipes lengths(where N>0).
	 
	Output Format:
	You need to return An array (L) containing the lengths of pipes joined that is sorted 
	in ascending order.
	
	
	Sample Test case:
	----------------
	Sample Input:
	4
	4
	3
	2
	6
	
	Sample Output:
	5
	9
	15
 * @author Ranger Raju :P
 *
 */
public class BRIDGECONSTRUCTIONCOMPANY {

	public static void main(String[] args) {
		int[] inpArr={4,3,2,6};
		int[] outputArr=getJoinedPipes(inpArr);
		for (int i = 0; i < outputArr.length; i++) {
			System.out.print(outputArr[i]+"\t");
		}
	}
	
	public static int[] getJoinedPipes(int[] input){
		Arrays.sort(input);
		int len=input.length;
		int[] costArr= new int[len-1];
		if(len == 1){
			costArr[0]=0;
		}else if(len > 1){
			int cost=input[0];
			for (int i = 1; i < len; ++i) {
				cost+=input[i];
				costArr[i-1]=cost;
			}
		}
		return costArr;
    }

}
