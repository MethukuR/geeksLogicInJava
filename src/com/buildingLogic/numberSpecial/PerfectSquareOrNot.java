package com.buildingLogic.numberSpecial;

public class PerfectSquareOrNot {

	public static void main(String[] args) {
		int inputNumber = 25;
		/*
		 * if(isPerfectSquareOptimized(inputNumber)){ System.out.println("Yes"); } else{
		 * System.out.println("No"); }
		 */

		System.out.println(findSquareRoot(999999999));

	}

	private static boolean isPerfectSquare(int inputNumber) {

		for (int i = 1; i * i <= inputNumber; ++i) {
			if (i * i == inputNumber) {
				return true;
			}
		}
		return false;
	}

	private static boolean isPerfectSquareOptimized(int inputNumber) {

		int first = 1;
		int last = inputNumber;

		while (first <= last) {
			int mid = last - (last - first) / 2;
			if (mid * mid == inputNumber) {
				return true;
			} else if (mid * mid > inputNumber) {
				last = mid - 1;
			} else {
				first = mid + 1;
			}
		}

		return false;

	}

	private static int findSquareRoot(int inputNumber) {

		if (inputNumber == 0 || inputNumber == 1) {
			return inputNumber;
		}

		long first = 1;
		long last = inputNumber;

		long squareRoot = -1;

		while (first <= last) {
			long mid = last - (last - first) / 2;
			long temp = mid*mid;
			if (temp == inputNumber) {
				squareRoot = mid;
				break;
			} else if (temp > inputNumber) {
				last = mid - 1;
			} else {
				first = mid + 1;
				squareRoot = mid;
			}
		}

		return (int)squareRoot;
	}

}
