package com.buildingLogic.arraySpecial;

public class TestArrays {

	public static void main(String[] args) {
		int[] arr = new int[10];
		
		for(int i =0; i < arr.length; ++i) {
			arr[i] = 36;
		}
		
		int sum = sum(arr);
		System.out.println(sum);
	}

	private static int sum(int[] arr) {
		int sum =0; 
		
		for (int i = 0; i < arr.length; i++) {
			sum = sum +arr[i];
		}
		
		return sum;
	}                

}

//for
//while
//do while
