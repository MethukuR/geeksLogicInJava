package com.buildingLogic.sonalspecial;

public class TernaryOperators {

	public static void main(String[] args) {
		int v1 = 10;
		int v2 = 20;
		
		int vMax = (v1 > v2) ? v1 : v2;
		
		System.out.println(vMax);
		
		int a1 = 10;
		int a2 = 20;
		
		int aMax;
		
		if(a1 > a2) {
			aMax = a1;
		}else {
			aMax= a2;
		}
		
		System.out.println(aMax);
	}

}
