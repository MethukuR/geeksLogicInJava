package com.improvingLogic;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

public class GameCenter {

	public static void main(String[] args) {
		String[] strArr={
				"12#45#33",
				"94#54#23",
				"98#59#27"

		};
		
		int[][] blocksArr=formBlocksArr(strArr);
		String[] positions=findPositions(blocksArr);
		for (int j = 0; j < positions.length; ++j) {
				System.out.println(positions[j]);
		}
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
		
		for (int i = 0; i < strArrLen ; ++i) {
			for (int j = 0; j < strArrLen; ++j) {
				System.out.print(blocksArr[i][j]+"\t");
			}
			System.out.println();
		}
		return blocksArr;
	}

}
