package com.buildingLogic.numberSpecial;
/**
 * Write a java program to find the largest number ‘L’ less than a given number ‘N’ 
 * which should not contain a given digit ‘D’. For example, If 145 is the given 
 * number and 4 is the given digit, then you should find the largest number less
 * than 145 such that it should not contain 4 in it. In this case, 139 will be the 
 * answer.


 
	Logic Used :
	----------
	We keep on decrementing the given number by 1 until we get the number which does not contain a given 
	digit. For this, we convert the given number to string ( Integer.toString(i) ) and given digit to 
	character ( char c = Integer.toString(digit).charAt(0) ). And check whether that string contains the 
	character ‘c’ or not ( Integer.toString(i).indexOf(c) ). If it contains, again we decrement the given 
	number and convert it to string and check whether this string contains the character ‘c’ or not. We 
	will continue this until we get the number which does not contain a given digit.
 
 * @author Raju :P
 *
 */
public class LargestNumberLessThanGivenNumber {

	public static void main(String[] args) {
		int inputNumber=145;
		int givenDigit=4;
		
		findLargestNumberLessThanGivenNumber(inputNumber,givenDigit);

	}

	private static void findLargestNumberLessThanGivenNumber(int inputNumber,int givenDigit) {
		
		//Converting digit to char
		 
        char c = Integer.toString(givenDigit).charAt(0);
 
        //Decrementing number & checking whether it contains digit
        
        int requiredNumber=-1;
        for (int i = inputNumber; i > 0; --i)
        {
            if(Integer.toString(i).indexOf(c) == -1)
            {
                //If 'i' doesn't contain 'c'
 
            	requiredNumber=i;
            	break;
            }
        }
 
       if(requiredNumber != -1){
    	   System.out.println("Required Number : "+ requiredNumber);
       }
       else{
    	   System.out.println("No such number exists");
       }
	}

}
