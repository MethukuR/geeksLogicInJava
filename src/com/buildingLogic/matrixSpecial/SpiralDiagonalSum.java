package com.buildingLogic.matrixSpecial;
/**
 * Sum of both diagonals of a spiral odd-order square matrix:
 * ----------------------------------------------------------
	We have given a spiral matrix of odd-order, in which we start with the number 1 
	as center and moving to the right in a clockwise direction.
	
	Examples:
	--------
	Input : n = 3 
	Output : 25
	
	Explanation :
	------------- 
	spiral matrix = 
	7 8 9
	6 1 2
	5 4 3
	The sum of diagonals is 7+1+3+9+5 = 25
	
	Input : n = 5
	Output : 101
	
	Explanation : 
	------------
	spiral matrix of order 5
	21 22 23 23 25
	20  7  8  9 10
	19  6  1  2 11
	18  5  4  3 12
	17 16 15 14 13
	The sum of diagonals is 21+7+1+3+13+
	25+9+5+17 = 101
	
	If we take a closer look at the spiral matrix of n x n, we can notice that top 
	right corner element has value n2. Value of top left corner is (n^2) – (n-1) 
	[Why? not that we move ant-clockwise in spiral matrix, therefore we get value of 
	top left after subtracting n-1 from top right]. Similarly values of bottom left 
	corner is (n^2) – 2(n-1) and bottom right corner is (n^2) – 3(n-1). After adding 
	all the four corners we get 4[(n^2)] – 6(n-1).

	Let f(n) be sum of diagonal elements for a n x n matrix. Using above observations, 
	we can recursively write f(n) as:
	
	f(n) = 4[(n^2)] – 6(n-1) + f(n-2)  
	From above relation, we can find the sum of all diagonal elements of a spiral 
	matrix with the help of iterative method.
	
	spiralDiaSum(n)
	{
	    if (n == 1)
	       return 1;
	
	    // as order should be only odd
	    // we should pass only odd-integers
	    return (4*n*n - 6*n + 6 + spiralDiaSum(n-2));
	}
 * 
 * @author Ranger Raju :P
 *
 */
public class SpiralDiagonalSum {

	public static void main(String[] args) {
		int n=7;
		System.out.println(spiralDiagonalsSum(n));
	}

	private static int spiralDiagonalsSum(int n) {
		if(n == 1){
			return 1;
		}else{
			return 4*n*n - 6*n+6 + spiralDiagonalsSum(n-2);
		}
	}

}
