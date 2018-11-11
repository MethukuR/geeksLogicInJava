package com.buildingLogic.arraySpecial; 
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
	Constraints: 1≤m,n≤100 
	1≤ element of array≤100000
	Sample Input: 
	10
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
class ArraysAndMerging {
	
	//Chintu's Approach
	/*public static void main(String[] args) {
		int[] arr1 = {112, 123, 3, 28, 99, 108, 291, 543, 934, 1221};
		int[] arr2 = {5, 104, 111};
		
		findSmallestUnion(arr1, arr2);
	}
	static void findSmallestUnion(int[] arr1, int[] arr2){
		int k2 =9;
		TreeSet ts = new TreeSet();
		for(int k : arr1){
			ts.add(k);
		}
		for(int k1 : arr2){
			ts.add(k1);
		}
		Object[] arr3=ts.toArray();
		for(int i=0; i<arr3.length; i++){
			if(k2==i){
				System.out.println(arr3[i-1]);
			}
		}
		
		
		
	}*/
	
 
	public static void main(String[] args) {
		int[] arrOne={3, 28, 99, 108, 112, 123, 291, 543, 934, 1221};
		int[] arrTwo={5, 104, 111};
		int k=9;
		int kthSmallest=findKthSmallest(arrOne,arrTwo,k);
		System.out.println(kthSmallest);
	}
 
	private static int findKthSmallest(int[] arrOne, int[] arrTwo,int k) {
		int kthSmallest=-1;
		TreeSet<Integer> hs= new TreeSet<Integer>();
		for (int i : arrOne) {
			hs.add(i);
		}
		for (int i :arrTwo) {
			hs.add(i);
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