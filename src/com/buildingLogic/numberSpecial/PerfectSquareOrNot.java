package com.buildingLogic.numberSpecial;

public class PerfectSquareOrNot {

	public static void main(String[] args) {
		int inputNumber=25;
		if(isPerfectSquareOptimized(inputNumber)){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}

	}

	private static boolean isPerfectSquare(int inputNumber) {
		
		for (int i = 1; i*i <= inputNumber; ++i) {
			if(i*i == inputNumber){
				return true;
			}
		}
		return false;
	}
	
    private static boolean isPerfectSquareOptimized(int inputNumber) {
		
		int first = 1;
		int last = inputNumber;
		
		while(first <= last){
			int mid = last-(last-first)/2;
			if(mid*mid == inputNumber){
				return true;
			}
			else if(mid*mid > inputNumber){
				last=mid-1;
			}
			else{
				first=mid+1;
			}
		}
		
		return false;
		
	}


}
