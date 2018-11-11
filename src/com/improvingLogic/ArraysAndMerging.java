package com.improvingLogic;

import java.util.Iterator;
import java.util.TreeSet;


/**
 *  Problem: Cody's girlfriend loves Arrays.She is a sorted girl, hence likes sorted arrays. Being 
 *  a Coder Cody decide to give her some sorted arrays but this time she demanded even more, she 
 *  said she needed kth smallest element in the union of the arrays, now cody is really puzzled. 
 *  He don't have an idea to do this, you need to help Cody making a program to do so.
	Input: First line of the input contains integer m, follows by m integers separated by space, 
	elements of 1st array
	Next line contains integer n, follows by n integers separated by space, elements of 2nd array.
	Last line contains k.
	Output: Print the kth smallest element of the merged array.
	Constraints: 1 ≤ m,n ≤ 100 
	1≤ element of array ≤ 100000
	Sample Input: 10
	3 28 99 108 112 123 291 543 934 1221
	3
	5 104 111
	9
	Sample Output: 
	123
 * 
 * @author Raju Rockzz :P
 *
 */
public class ArraysAndMerging {

	public static void main(String[] args) {
		int[] arrOne={3, 28, 99, 108, 112, 123, 291, 543, 934, 1221};
		int[] arrTwo={5, 104, 111};
		int k=9;
		int kthSmallest=findKthSmallest(arrOne,arrTwo,k);
		
		System.out.println(kthSmallest);
		
	}

	private static int findKthSmallest(int[] arrOne, int[] arrTwo,int k) {
		int kthSmallest=-1;
		int arrOneLength=arrOne.length;
		int arrTwoLength=arrTwo.length;
		TreeSet<Integer> hs= new TreeSet<Integer>();
		for (int i = 0; i < arrOneLength ; ++i) {
			hs.add(Integer.valueOf(arrOne[i]));
		}
		for (int i = 0; i < arrTwoLength ; ++i) {
			hs.add(Integer.valueOf(arrTwo[i]));
		}
		
		if(k <= hs.size()){
			Iterator<Integer> itr = hs.iterator();
			int count=0;
			while(itr.hasNext()){
				int element=itr.next();
				++count;
				if(count == k){
					kthSmallest=element;
					break;
				}
			}
		}
		return kthSmallest;
	}

}
