package com.improvingLogic;

public class MinMaxOfArray {

	public static void main(String[] args) {
		int arr[] = {1000, 11, 445, 1, 330, 3000};
		int arrLength=arr.length;
		//int sum =IntStream.of(arr).sum();
		MinMax minMax=findMinMaxOne(arr,arrLength);
		
		System.out.println("MinValue : "+ minMax.minValue);
		System.out.println("MaxValue : "+ minMax.maxValue);
	}
	
	static MinMax findMinMaxOne(int[] arr, int arrLength){
		MinMax minMax= new MinMax();
		if(arrLength==1){
			minMax.maxValue=arr[0];
			minMax.minValue=arr[0];
		}
		else{
			if(arr[0]>arr[1]){
				minMax.maxValue=arr[0];
				minMax.minValue=arr[1];
			}
			else{
				minMax.maxValue=arr[1];
				minMax.minValue=arr[0];
			}
			for(int index=2;index<arrLength;++index){
				if(arr[index]>minMax.maxValue){
					minMax.maxValue=arr[index];
				}
				else if(arr[index]<minMax.minValue){
					minMax.minValue=arr[index];
				}
			}
		}
		return minMax;
	}
}

class MinMax{
	int minValue;
	int maxValue;
}
