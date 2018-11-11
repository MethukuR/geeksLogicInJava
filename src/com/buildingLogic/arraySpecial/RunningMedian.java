package com.buildingLogic.arraySpecial;

public class RunningMedian {
	public static void main(String[] args) {
		int[] a = { 12, 4, 5, 1, 2, 3, 8, 7 };
		findRunningMedian(a);
	}

	static void findMedian(int[] list, int listLength) {
		double median = 0;
		if ((listLength & 1) != 0) {
			median = list[(listLength / 2)];
			System.out.print(median + "\t");
		} else {
			median = (double) (list[(listLength / 2) - 1] + list[(listLength / 2)]) / 2;
			System.out.print(median + "\t");
		}
	}

	private static void findRunningMedian(int[] inputArray) {
		int inputArrayLength = inputArray.length;
		System.out.print((double)inputArray[0] + "\t");
		for (int i = 1; i < inputArrayLength; i++) {
			int value = inputArray[i];
			int hole = i;

			while (hole > 0 && (inputArray[hole - 1] > value)) {
				inputArray[hole] = inputArray[hole - 1];
				hole = hole - 1;
			}
			inputArray[hole] = value;
			findMedian(inputArray, i + 1);
		}
	}
}
