package com.improvingLogic;

/**
 *                1
                1 2 1
              1 2 3 2 1
            1 2 3 4 3 2 1
          1 2 3 4 5 4 3 2 1
        1 2 3 4 5 6 5 4 3 2 1
      1 2 3 4 5 6 7 6 5 4 3 2 1
    1 2 3 4 5 6 7 8 7 6 5 4 3 2 1
  1 2 3 4 5 6 7 8 9 8 7 6 5 4 3 2 1
  
  In this problem, we print i*2 spaces at the beginning of each row instead of just i spaces. 
  At the end of each row, we print ‘j’ where j value will be from 1 to rowCount and from rowCount-1
   to 1.
 */

import java.util.Scanner;

public class Pyramid121 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter number of rows of pyramid");
		int numberOfRows=scn.nextInt();
		System.out.println("Number Of Rows"+numberOfRows);
		int rowCount=1;
		int[] arr= {1,2};
		//System.out.println("Sum",IntStream.of(arr).sum());
		for (int i = numberOfRows; i >0; --i) {
			
			for (int j = 1; j <= (i*2); ++j) {
				System.out.print(" ");
			}
			
			for (int j = 1; j <= rowCount; ++j) {
				System.out.print(j+" ");
			}
			
			for (int j = rowCount-1; j >=1; --j) {
				System.out.print(j+" ");
			}
			
			System.out.println("");
			++rowCount;
		}
	}

}
