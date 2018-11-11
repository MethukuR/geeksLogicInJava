package com.buildingLogic.matrixSpecial;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * You and your friend go to a game arcade where you choose to play the lucky pick game. In the game, 
 * there is a square grid and on each block some money is placed on it. When a player chooses a block, 
 * the machine randomly chooses a block from the available neighbouring and the chosen block (consider 8 
 * neighbourhood). The player is awarded the money that is placed on the block that the machine selects. 
 * Your friend needs help choosing the block.

	Your job is to return the block position(s) that will maximize the minimum amount your friend will win 
	for sure. If there are more than one such block positions then output must return all these positions.
	
	
	Input Format:
	You will be given a function which contains single argument representing the Grid Description(in the 
	form of string array) {N rows each containing N numbers separated by '#', each number representing the 
	amount of money put on that block}
	
	Output Format:
	You need to return the array of string containing the position(s) of a block choosing which will give 
	the maximum amount of money which your friend will definitely win.
	
	
	Sample Test Case 1:
	------------------
	Sample Input
	3
	12#45#33
	94#54#23
	98#59#27
	
	Sample Output:
	3#1
	
	Explanation:
	------------
	In the above example, if he selects the block (3,1), then under the best case, he could win is 98 and 
	under the worst case the maximum he could win is 54. In such scenario, the worst case of block (3,1) 
	gives your friend more money than the worst case of other blocks.
	
	Sample Test Case 2:
	-------------------
	Sample Input:
	4
	12#45#33#27
	94#54#23#53
	98#59#27#62
	11#51#67#13
	
	Sample Output:
	1#3
	1#4
	2#3
	2#4                                                                           
	
	Note:  If the output array contains multiple strings(block's positions), all the positions must be in 
	the row-wise traversal order. In Example 2, the output is {1#3,1#4,2#3,2#4}. If your function is 
	returning an array that has same elements (block's position) but in the different order, then the 
	output array will be incorrect.

 * @author Ranger Raju :P
 *
 */
public class GameCenter {

	public static void main(String[] args) {
		String[] input1={
				"12#45#33#27",
				"94#54#23#53",
				"98#59#27#62",
				"11#51#67#13"
		};
		String[] output=amount_value(input1);
		
		for (int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}
	
	public static String[] amount_value(String[] input1)
    {
	    int[][] blocksArr=formBlocksArr(input1);
		return findPositions(blocksArr);
    }
    
    private static String[] findPositions(int[][] blocksArr) {
		int blocksArrLen=blocksArr.length;
		HashMap<String,Integer> position= new LinkedHashMap<>();
		String[] resultPositions= new String[blocksArrLen*blocksArrLen];
		for (int i = 0; i < blocksArrLen ; ++i) {
			for (int j = 0; j < blocksArrLen; ++j) {
				position.put((i+1)+"#"+(j+1), finMin(i,j,blocksArrLen,blocksArr));
 			}
		}
		int curMax= Integer.MIN_VALUE;
		for (int is : position.values()) {
			if(is > curMax){
				curMax=is;
			}
		}
		
		
		int index=0;
		for (Map.Entry<String, Integer> entry : position.entrySet()) {
		   if(entry.getValue() == curMax){
			   resultPositions[index]=entry.getKey();
			   ++index;
		   }
		}
		
		String[] positions= new String[index];
		for (int j = 0; j < resultPositions.length; ++j) {
			if(null != resultPositions[j]){
				positions[j]=resultPositions[j];
			}
			
		}
		return positions;
	}

	private static Integer finMin(int i, int j,int blocksArrLen,int[][] blocksArr) {
		TreeSet<Integer> ts = new TreeSet<>();
		if(isValidposition(i-1,j-1,blocksArrLen)){
			ts.add(blocksArr[i-1][j-1]);
		}
        if(isValidposition(i-1,j,blocksArrLen)){
        	ts.add(blocksArr[i-1][j]);
		}
        if(isValidposition(i-1,j+1,blocksArrLen)){
        	ts.add(blocksArr[i-1][j+1]);
		}
        if(isValidposition(i,j-1,blocksArrLen)){
        	ts.add(blocksArr[i][j-1]);
		}
        if(isValidposition(i,j,blocksArrLen)){
        	ts.add(blocksArr[i][j]);
		}
        if(isValidposition(i,j+1,blocksArrLen)){
        	ts.add(blocksArr[i][j+1]);
		}
        if(isValidposition(i+1,j-1,blocksArrLen)){
        	ts.add(blocksArr[i+1][j-1]);
		}
        if(isValidposition(i+1,j,blocksArrLen)){
        	ts.add(blocksArr[i+1][j]);
		}
        if(isValidposition(i+1,j+1,blocksArrLen)){
        	ts.add(blocksArr[i+1][j+1]);
		}
		return ts.first();
	}

	private static boolean isValidposition(int i, int j,int blocksArrLen) {
		if(i >=0 && i < blocksArrLen && j >=0 && j < blocksArrLen){
				return true;
		}
		return false;
	}

	private static int[][] formBlocksArr(String[] strArr) {
		
		int strArrLen=strArr.length;
		int[][] blocksArr= new int[strArrLen][strArrLen];
		for (int i = 0; i < strArrLen ; ++i) {
			String[] row= strArr[i].split("#");
			for (int j = 0; j < strArrLen; ++j) {
				blocksArr[i][j]=Integer.parseInt(row[j]);
			}
		}
		return blocksArr;
	}

}
