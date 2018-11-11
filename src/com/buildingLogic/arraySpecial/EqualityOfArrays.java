package com.buildingLogic.arraySpecial;

import java.util.Arrays;

/**
 * Two arrays are said to be equal if the arrays have equal number of elements and all corresponding 
 * pairs of elements in two arrays are equal. In the other words, two arrays are said to be equal if 
 * both the arrays have same elements in the same order. You are very often need to compare two arrays 
 * for equality while developing the applications. This is also one of the important  java interview 
 * question for 1 or 2 years experienced java professionals.
 

	1) Iterative Method :

	In this method, first we check length of two given arrays. If the length of both arrays is same, 
	then we compare corresponding pairs of elements of both the arrays. If all corresponding pairs of 
	elements are equal, then given arrays will be considered as equal. This method will be time 
	consuming if the arrays have lots of elements. This method is not recommended to check the 
	equality of two arrays if the arrays are big in size. But in the interview, interviewer may ask 
	you to compare two arrays without using in-built functions. In that time, this method may help you.
	
	
	2) Using Arrays.equals() Method :
	
	In this method, we use in-built equals() method of Arrays class to check the equality of two arrays. 
	This method takes two arrays as parameters and returns true if both the arrays have same number of 
	elements and corresponding pairs of elements of both arrays are equal.
	
	If you want to compare two arrays which have same number of elements and same set of elements but 
	in different positions, then first sort both arrays using Arrays.sort() method and then compare 
	using Arrays.equals() method.
	
	3) Using Arrays.deepEquals() Method :
	
	If you are checking multidimensional arrays for equality, then use deepEquals() method of Arrays 
	class instead of equals() method. Because, deepEquals() performs deep comparison of both the arrays.
	
 * @author Raju :)
 *
 */
public class EqualityOfArrays {

	public static void main(String[] args) {
		equalityOfArraysIterative();
		equalityOfArraysEqualsMethod();
		equalityOfArraysDeepEqualsMethod();

	}

	private static void equalityOfArraysDeepEqualsMethod() {
		String[][] s1 = { {"java", "swings", "j2ee" }, { "struts", "jsp", "hibernate"} };
		 
        String[][] s2 = { {"java", "swings", "j2ee" }, { "struts", "jsp", "hibernate"} };
 
        System.out.println(Arrays.deepEquals(s1, s2));     //Output : true
         
        //Calling equals() method on same arrays will return false
         
        System.out.println(Arrays.equals(s1, s2));        //Output : false
         
        //That's why use deepEquals() method to compare multidimensional arrays
		
	}

	private static void equalityOfArraysEqualsMethod() {
		String[] s1 = {"java", "j2ee", "struts", "hibernate"};
		 
        String[] s2 = {"jsp", "spring", "jdbc", "hibernate"};
 
        String[] s3 = {"java", "j2ee", "struts", "hibernate"};
 
        System.out.println(Arrays.equals(s1, s2));        //Output : false
 
        System.out.println(Arrays.equals(s1, s3));      //Output : true
        
        String[] str1 = {"java", "swings", "j2ee", "struts", "jsp", "hibernate"};
   	 
        String[] str2 = {"java", "struts", "j2ee", "hibernate", "swings", "jsp"};
 
        Arrays.sort(str1);
 
        Arrays.sort(str2);
 
        System.out.println(Arrays.equals(str1, str2));       //Output : true
		
	}

	private static void equalityOfArraysIterative() {
		int[] arrayOne = {2, 5, 1, 7, 4};
        
        int[] arrayTwo = {2, 5, 1, 7, 4};
         
        boolean equalOrNot = true;
         
        if(arrayOne.length == arrayTwo.length){
            for (int i = 0; i < arrayOne.length; ++i){
                if(arrayOne[i] != arrayTwo[i]){
                    equalOrNot = false;
                }
            }
        }
        else{
            equalOrNot = false;
        }
         
        if (equalOrNot){
            System.out.println("Two Arrays Are Equal");
        }
        else{
            System.out.println("Two Arrays Are Not equal");
        }
    }
		
	

}
