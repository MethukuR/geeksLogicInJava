package com.buildingLogic.arraySpecial;

/**
 * You are given an array of numbers. Find out the array index or position where sum of 
 * numbers preceeding the index is equals to sum of numbers succeeding the index.
 * 
 * Example:
 * --------
 * Input :{ 2, 4, 4, 5, 4, 1 }
 * 
 * output: 2
 * 
 * @author Ranger Raju :P
 *
 */
public class EquilibruimPoint {

	public static void main(String[] args) {
		int[] inpArr={ 2, 4, 4, 5, 4, 1 };
		findEquilibriumIndex(inpArr);
	}

	private static void findEquilibriumIndex(int[] inpArr) {
		int start=0;
		int end=inpArr.length-1;
		int sumLeft=0;
		int sumRight=0;
		int equilibriumIndex=-1;
		while(true){
			if(sumLeft > sumRight){
				sumRight+=inpArr[end--];
			}
			else{
				sumLeft+=inpArr[start++];
			}
			
			if(start > end){
				if(sumLeft == sumRight){
					equilibriumIndex= end;
				}
				break;
			}
		}
		
		System.out.println(equilibriumIndex);
		
	}

}
