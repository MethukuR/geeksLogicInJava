package com.improvingLogic;
/**
 * The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens
 * attack each other
 * 
 * The expected output is a binary matrix which has 1s for the blocks where queens are placed. 
 * For example, following is the output matrix for above 4 queen solution.

              { 0,  1,  0,  0}
              { 0,  0,  0,  1}
              { 1,  0,  0,  0}
              { 0,  0,  1,  0}
 * @author Raju Rockzz :P
 *
 */
public class NQueensProblem {
	static int[] positions= new int[100];
	public static void main(String[] args) {
		solutionOfNQueens(0, 8);
	}
	
	static boolean canQueenBePlacedAt(int rowIndex,int columnIndex){
		//returns true if queen can be placed at rowIndex numbered row and column index numbered 
		//column and positions[rowIndex] is an global array with first rowIndex-1 elements already set
		boolean status= true;
		
		for (int i = 0; i < rowIndex; i++) {
			if((positions[i] == columnIndex) || (Math.abs(positions[i]-columnIndex) == Math.abs(i-rowIndex))){
				status=false;
			}
		}
		return status;
		
	}
	
	static void solutionOfNQueens(int rowNumber,int size){
		for (int i = 0; i < size; i++) {
			if(canQueenBePlacedAt(rowNumber, i)){
				positions[rowNumber]=i;
				if(rowNumber == size-1){
					for (int j = 0; j < 8; j++) {
						System.out.println(j+"-->"+positions[j]);
					}
				}
				else{
					solutionOfNQueens(rowNumber+1, size);
				}
			}
		}
	}

}
