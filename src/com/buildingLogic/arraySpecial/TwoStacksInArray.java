package com.buildingLogic.arraySpecial;

import java.util.Scanner;

public class TwoStacksInArray {
	static int[] inpArr= new int[6];
	static int topOne=-1;
	static int topTwo=inpArr.length;
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		while(true){
			System.out.println("Choose Your Operation : \n 1. Push In Stack One \n 2. Push In Stack Two \n 3. Display Stack \n 4. Pop From Stack One \n 5. Pop From Stack Two");
			int caseNo=scn.nextInt();
			scn.close();
			switch(caseNo){
				case 1:{
					pushOne();
					break;
				}
				case 2:{
					pushTwo();
					break;
				}
				case 3:{
					displayStack();
					break;
				}
				case 4:{
					popOne();
					break;
				}
				case 5:{
					popTwo();
					break;
				}
			}
		}
	}

	private static void popTwo() {
		if(topTwo == inpArr.length){
			System.out.println("stack One Is Empty");
			return;
		}
		System.out.println(inpArr[topTwo++]);
		
	}

	private static void popOne() {
		if(topOne == -1){
			System.out.println("stack One Is Empty");
			return;
		}
		System.out.println(inpArr[topOne--]);
		
	}

	private static void pushOne() {
		if(topOne == topTwo -1){
			System.out.println("Stack One is Full");
			return;
		}
		System.out.println("Enter element you want to push : ");
		Scanner scn = new Scanner(System.in);
		int number= scn.nextInt();
		
		inpArr[++topOne] = number;
		
		scn.close();
	}

	private static void pushTwo() {
		if(topOne == topTwo -1){
			System.out.println("Stack Two is Full");
			return;
		}
		System.out.println("Enter element you want to push : ");
		Scanner scn = new Scanner(System.in);
		int number= scn.nextInt();
		
		inpArr[--topTwo] = number;
		
		scn.close();
	}

	private static void displayStack() {
		int i =0;
		if(topOne == -1){
			System.out.println("Stack One is Empty");
		}else{
			i=topOne;
			System.out.println("Stack One :");
			 while(i >= 0){
				 System.out.print(inpArr[i--]+ "\t");
			 }
			
		}
		
		if(topTwo == inpArr.length){
			System.out.println("Stack Two is Empty");
		}else{
			i=topTwo;
			System.out.println("\nStack Two :");
			 while(i < inpArr.length){
				 System.out.print(inpArr[i++]+ "\t");
			 }
			
		}
	}

}
