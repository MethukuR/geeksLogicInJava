package com.buildingLogic.numberSpecial;

import java.util.Scanner;

/**
 * 1. Pattern One
 *  
 *  1
	1 2
	1 2 3
	1 2 3 4
	1 2 3 4 5
	1 2 3 4 5 6
	1 2 3 4 5 6 7
	
	2. Pattern Two
	
	1
	2 2
	3 3 3
	4 4 4 4
	5 5 5 5 5
	6 6 6 6 6 6
	7 7 7 7 7 7 7
	
	3. Pattern Three
	
	1
	1 2
	1 2 3
	1 2 3 4
	1 2 3 4 5
	1 2 3 4 5 6
	1 2 3 4 5 6 7
	1 2 3 4 5 6
	1 2 3 4 5
	1 2 3 4
	1 2 3
	1 2
	1
	
	4. Pattern Four
	
	1 2 3 4 5 6 7
	1 2 3 4 5 6
	1 2 3 4 5
	1 2 3 4
	1 2 3
	1 2
	1
	
	5. Pattern Five
	
	7 6 5 4 3 2 1
	7 6 5 4 3 2
	7 6 5 4 3
	7 6 5 4
	7 6 5
	7 6
	7
	
	6. Pattern Six
	
	7
	7 6
	7 6 5
	7 6 5 4
	7 6 5 4 3
	7 6 5 4 3 2
	7 6 5 4 3 2 1
	
	7. Pattern Seven
	
	7 6 5 4 3 2 1
	6 5 4 3 2 1
	5 4 3 2 1
	4 3 2 1
	3 2 1
	2 1
	1
	
	8. Pattern Eight
	
	1 2 3 4 5 6 7
	1 2 3 4 5 6
	1 2 3 4 5
	1 2 3 4
	1 2 3
	1 2
	1
	1 2
	1 2 3
	1 2 3 4
	1 2 3 4 5
	1 2 3 4 5 6
	1 2 3 4 5 6 7
	
	9. Pattern Nine
	
	1
	1 2 1
	1 2 3 2 1
	1 2 3 4 3 2 1
	1 2 3 4 5 4 3 2 1
	1 2 3 4 5 6 5 4 3 2 1
	1 2 3 4 5 6 7 6 5 4 3 2 1
	
	10. Pattern Ten
	
	1
	2 1
	3 2 1
	4 3 2 1
	5 4 3 2 1
	6 5 4 3 2 1
	7 6 5 4 3 2 1
	
	11. Pattern Eleven
	
	1234567
	 234567
	  34567
	   4567
	    567
	     67
	      7
	     67
	    567
	   4567
	  34567
	 234567
	1234567
	
	12. Pattern Twelve
	
	1 2 3 4 5 6 7
	 2 3 4 5 6 7
	  3 4 5 6 7
	   4 5 6 7
	    5 6 7
	     6 7
	      7
	     6 7
	    5 6 7
	   4 5 6 7
	  3 4 5 6 7
	 2 3 4 5 6 7
	1 2 3 4 5 6 7
	
	13. Pattern Thirteen
	
	1
	10
	101
	1010
	10101
	101010
	1010101
	
	14. Pattern Fourteen
	
	1010101
	0101010
	1010101
	0101010
	1010101
	0101010
	1010101
	
	15. Pattern Fifteen
	
	1111111
	1111122
	1111333
	1114444
	1155555
	1666666
	7777777
	
	16. Pattern Sixteen
	
	0000000
	0100000
	0020000
	0003000
	0000400
	0000050
	0000006
	
	17. Pattern Seventeen
	
	1
	2 6
	3 7 10
	4 8 11 13
	5 9 12 14 15
	
	18. Pattern Eighteen
	
			1
		   212
		  32123
		 4321234
		543212345



 * @author Raju Rockzz :P
 *
 */

public class NumberPatterns {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter number of rows : ");
		int noOfRows= scn.nextInt();
		//printPatternOne(noOfRows);
		//printPatternTwo(noOfRows);
		//printPatternThree(noOfRows);
		//printPatternFour(noOfRows);
		//printPatternFive(noOfRows);
		//printPatternSix(noOfRows);
		//printPatternSeven(noOfRows);
		//printPatternEight(noOfRows);
		//printPatternNine(noOfRows);
		//printPatternTen(noOfRows);
		//printPatternEleven(noOfRows);
		//printPatternTwelve(noOfRows);
		//printPatternThirteen(noOfRows);
		//printPatternFourteen(noOfRows);
		//printPatternFifteen(noOfRows);
		//printPatternSixteen(noOfRows);
		//printPatternSeventeen(noOfRows);
		printPatternEighteen(noOfRows);
		scn.close();
	}
	
	static void printPatternOne(int noOfRows){
		System.out.println("************************* PATTERN ONE **************************");
		
		for (int i = 1; i <= noOfRows; ++i) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	
	static void printPatternTwo(int noOfRows){
		System.out.println("************************* PATTERN TWO **************************");
		
		for (int i = 1; i <= noOfRows; ++i) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	
	static void printPatternThree(int noOfRows){
		System.out.println("************************* PATTERN THREE **************************");
		
		for (int i = 1; i <= noOfRows; ++i) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
		for (int i = noOfRows-1; i > 0; --i) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	
	static void printPatternFour(int noOfRows){
		System.out.println("************************* PATTERN FOUR **************************");
		
		for (int i = noOfRows; i > 0; --i) {
			for (int j = 1; j <= i; ++j) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	
	static void printPatternFive(int noOfRows){
		System.out.println("************************* PATTERN FIVE **************************");
		
		for (int i = noOfRows; i > 0; --i) {
			for (int j = i; j > 0; --j) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	
	static void printPatternSix(int noOfRows){
		System.out.println("************************* PATTERN SIX **************************");
		
		for (int i = noOfRows; i > 0; --i) {
			for (int j = noOfRows; j >= i; --j) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	
	static void printPatternSeven(int noOfRows){
		System.out.println("************************* PATTERN SEVEN **************************");
		
		for (int i = 1; i <= noOfRows; ++i) {
			for (int j = noOfRows; j >= i; --j) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	
	static void printPatternEight(int noOfRows){
		System.out.println("************************* PATTERN EIGHT **************************");

		for (int i = noOfRows; i > 0; --i) {
			for (int j = 1; j <= i; ++j) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
		for (int i = 2; i <= noOfRows; ++i) {
			for (int j = 1; j <= i; ++j) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	
	static void printPatternNine(int noOfRows){
		System.out.println("************************* PATTERN NINE **************************");

		for (int i = 1; i <= noOfRows; ++i) {
			for (int j = 1; j <= i; ++j) {
				System.out.print(j+" ");
			}
			
			for (int j = i-1; j >= 1; --j) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
	}
	
	static void printPatternTen(int noOfRows){
		System.out.println("************************* PATTERN TEN **************************");

		for (int i = 1; i <= noOfRows; ++i) {
			for (int j = i; j >= 1; --j) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
	}
	
	static void printPatternEleven(int noOfRows){
		System.out.println("************************* PATTERN ELEVEN **************************");

		for (int i = noOfRows; i > 0; --i) {
			for (int j = i; j <= noOfRows; ++j) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; ++j) {
				System.out.print(j);
			}
			System.out.println();
		}
		
		for (int i = 2; i <= noOfRows; ++i) {
			for (int j = noOfRows; j >= i; --j) {
				System.out.print(" ");
			}
			for (int j = i; j >= 1; --j) {
				System.out.print(j);
			}
			System.out.println();
		}
		
	}
	
	static void printPatternTwelve(int noOfRows){
		System.out.println("************************* PATTERN TWELVE **************************");
		
		for (int i = 1; i <= noOfRows; ++i) {
			for (int j = 1; j <= i; ++j) {
				System.out.print(" ");
			}
			for (int j = i; j <= noOfRows; ++j) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
		for (int i = noOfRows-1; i > 0; --i) {
			for (int j = 1; j <= i; ++j) {
				System.out.print(" ");
			}
			for (int j = i; j <= noOfRows; ++j) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
	}
	
	static void printPatternThirteen(int noOfRows){
		System.out.println("************************* PATTERN THIRTEEN **************************");
		
		for (int i = 0; i < noOfRows; ++i) {
			for (int j = 0; j <=i; ++j) {
				if( (j&1) == 0){
					System.out.print("1");
				}
				else{
					System.out.print("0");
				}
			}
			
			System.out.println();
		}
	}
	
	static void printPatternFourteen(int noOfRows){
		System.out.println("************************* PATTERN FOURTEEN **************************");
		int num;
		for (int i = 0; i < noOfRows; ++i) {
			if( (i&1) == 0 ){
				num=0;
				for (int j = 0; j < noOfRows; ++j) {
					System.out.print(num);
                    num = (num == 0)? 1 : 0;
				}
			}
			else{
				num=1;
				for (int j = 0; j < noOfRows; ++j) {
					System.out.print(num);
                    num = (num == 0)? 1 : 0;
				}
			}
			System.out.println();
		}
	}
	
	static void printPatternFifteen(int noOfRows){
		System.out.println("************************* PATTERN FIFTEEN **************************");
		for (int i = 1; i <= noOfRows; ++i) {
			for (int j = 1; j <= noOfRows-i; ++j) {
				System.out.print("1");
			}
			for (int j = 1; j <= i; ++j) {
				System.out.print(i);
			}
			
			System.out.println();
		}
	}
	
	static void printPatternSixteen(int noOfRows){
		System.out.println("************************* PATTERN SIXTEEN **************************");
		for (int i = 0; i < noOfRows; ++i) {
			for (int j = 0; j < noOfRows; ++j) {
				if( j == i ){
					System.out.print(i);
				}
				else{
					System.out.print("0");
				}
			}
			System.out.println();
		}
	}
	
	static void printPatternSeventeen(int noOfRows){
		System.out.println("************************* PATTERN SEVENTEEN **************************");
		for (int i = 1; i <= noOfRows; ++i) {
			int num=i;
			for (int j = 1; j <= i; ++j) {
				System.out.print(num+"\t");
				num=num+noOfRows-j;
			}
			System.out.println();
		}
	}
	
	static void printPatternEighteen(int noOfRows){
		System.out.println("************************* PATTERN EIGHTEEN **************************");
		int rowCount=noOfRows;
		for (int i = 1; i <= noOfRows; ++i) {
			for (int j =1; j <= (rowCount) ; ++j) {
				System.out.print(" ");
			}
			for (int j = i; j > 0 ; --j) {
				System.out.print(j);
			}
			for (int j = 2; j <= i ; ++j) {
				System.out.print(j);
			}
			System.out.println();
			--rowCount;
		}
	}

	


}