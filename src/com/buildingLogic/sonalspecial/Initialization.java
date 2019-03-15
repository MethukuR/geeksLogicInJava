package com.buildingLogic.sonalspecial;

public class Initialization {

	public static void main(String[] args) {

		byte b; // declaration
		byte b1 = 10; // declaration + initialization

		int a; // declaration
		a = 20; // initialization
		int a1 = 30; // declaration + initialization

		int[] arr = new int[10]; // declaration
		arr[0] = 1; // initialization
		// -
		// -
		// -
		arr[9] = 5;

		byte[] arr1 = { 1, 2, 3, 4, 5 }; // declaration + initialization
		
		// ==== 
		
		byte[] byArr = new byte[] { 1, 2, 3, 4, 5 }; // declaration + initialization
		// ====

		byte[] arr2 = new byte[5];
		arr2[0] = 1;
		arr2[1] = 2;
		arr2[2] = 3;
		arr2[3] = 4;
		arr2[4] = 5;

		String s; // declaration
		s = "sonal choudhary"; // initialization

		String str = "sonal choudhary"; // declaration + initialization
		String str2 = new String("sonal choudhary"); // declaration + initialization
		
		boolean bo; // declaration
		bo = false; //initialization
		
		boolean b01 = true; // declaration + initialization
		
		char c ; //declaration
		c = 'f'; //initialization
		
		char ch = 's'; // declaration + initialization
		
		System.out.println(ch); // s
		
		char ch1 = 104;
		System.out.println(ch1); // h

	}

}
