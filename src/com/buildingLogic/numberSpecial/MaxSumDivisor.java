package com.buildingLogic.numberSpecial;
import java.util.TreeMap;
import java.util.TreeSet;

public class MaxSumDivisor {

	public static void main(String[] args) {
		int number=403;
		int requiredNumber=findMaxSumDivisor(number);
		System.out.println("requiredNumber : "+requiredNumber);
	}
	
	static int findMaxSumDivisor(int number){
		int requiredNumber=0;
		TreeMap<Integer, TreeSet<Integer>> divisorMap= findDivisors(number);
		TreeSet<Integer> tset=divisorMap.get(divisorMap.lastKey());
		System.out.println("requiredKey : "+divisorMap.lastKey());
		requiredNumber=tset.first();
		return requiredNumber;
	}
	
	static TreeMap<Integer, TreeSet<Integer>> findDivisors(int number){
		TreeMap<Integer, TreeSet<Integer>> divisorMap= new TreeMap<Integer, TreeSet<Integer>>();
		
		for (int i = 1; i < number/2; ++i) {
			if((number%i) == 0){
				int sumOfDigits=findSumOfDigits(i);
				if(divisorMap.containsKey(sumOfDigits)){
					TreeSet<Integer> divisorSet=divisorMap.get(sumOfDigits);
					divisorSet.add(i);
					divisorMap.put(sumOfDigits,divisorSet);
				}
				else{
					TreeSet<Integer> divisorSet= new TreeSet<Integer>();
					divisorMap.put(sumOfDigits, divisorSet);
					divisorSet=divisorMap.get(sumOfDigits);
					divisorSet.add(i);
					divisorMap.put(sumOfDigits,divisorSet);
				}
			}
		}
		return divisorMap;
	}
	static int findSumOfDigits(int divisor){
		int sumOfDigits=0;
		while(divisor!= 0){
			int remainder=divisor%10;
			sumOfDigits+=remainder;
			divisor/=10;
		}
		return sumOfDigits;
	}
	

}
