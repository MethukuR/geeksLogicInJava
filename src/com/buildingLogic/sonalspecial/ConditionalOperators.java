package com.buildingLogic.sonalspecial;
/**
 * 
 * Conditional Operators:
 * ---------------------
 * 
 * & | => Logical Operators
 * && || => Conditional Operators
 * 
 * @author Raju
 *
 */
public class ConditionalOperators {

	public static void main(String[] args) {
		int a = 5;
		int b = 0;
		
		/*if(b > 0  && a/b > 0) {
			System.out.println(a/b);
		}else {
			System.out.println(b);
		}*/
		
		if(b < 0  || a/b > 0) {
			System.out.println(a/b);
		}else {
			System.out.println(b);
		}
	}

}
